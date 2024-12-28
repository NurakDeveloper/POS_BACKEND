package com.pos.pos_backend.mapper.orderMapper;

import com.pos.pos_backend.model.Dto.orderDto.InvoiceDto;
import com.pos.pos_backend.model.Dto.orderDto.InvoiceItemDto;
import com.pos.pos_backend.model.Dto.orderDto.OrderRequest;
import com.pos.pos_backend.model.entity.Branch;
import com.pos.pos_backend.model.entity.Customer;
import com.pos.pos_backend.model.entity.Employee;
import com.pos.pos_backend.model.entity.Product;
import com.pos.pos_backend.repository.BranchRepository;
import com.pos.pos_backend.repository.CustomerRepository;
import com.pos.pos_backend.repository.EmployeeRepository;
import com.pos.pos_backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class InvoiceMapper {

    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final ProductRepository productRepository;
    private final BranchRepository branchRepository;

    public InvoiceDto mapToInvoiceDto(OrderRequest orderRequest) {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setReceived(orderRequest.getCash());
        invoiceDto.setTotalDiscount(orderRequest.getTotalDiscount());
        invoiceDto.setInvoiceDate(orderRequest.getOrderDate());
        invoiceDto.setInvoiceNumber(orderRequest.getInvoiceNumber().toString());
        invoiceDto.setChange(orderRequest.getCash() - orderRequest.getTotalAmount());

        // Fetch Branch, Customer, and Employee details
        Branch branch = branchRepository.findById(orderRequest.getBranchId())
                .orElseThrow(() -> new IllegalArgumentException("Branch not found with ID: " + orderRequest.getBranchId()));

        Customer customer = customerRepository.findById(orderRequest.getCustomerId())
                .orElse(null);
        String customerName = (customer != null)
                ? customer.getFirstName() + " " + customer.getLastName()
                : "General";

        Employee employee = employeeRepository.findById(orderRequest.getAcceptedBy())
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with ID: " + orderRequest.getAcceptedBy()));

        invoiceDto.setBranchName(branch.getBranchName());
        invoiceDto.setCustomerName(customerName);
        invoiceDto.setStuff(employee.getFirstName() + " " + employee.getLastName());

        invoiceDto.setBranchName(branch.getBranchName());
        invoiceDto.setBranchPhoneNumber(branch.getPhoneNumber());
        invoiceDto.setBranchAddress(branch.getAddressLine1());
        invoiceDto.setTotalAmount(orderRequest.getTotalAmount());
        invoiceDto.setPaymentMethod("CASH");
        invoiceDto.setPaymentStatus("COMPLETE");


        // Fetch Products in batch to optimize queries
        List<Long> productIds = orderRequest.getOrderLines().stream()
                .map(line -> line.getProductId())
                .collect(Collectors.toList());

        Map<Long, Product> productMap = productRepository.findAllById(productIds).stream()
                .collect(Collectors.toMap(Product::getId, product -> product));

        // Map order lines to invoice items
        List<InvoiceItemDto> invoiceItemDtos = new ArrayList<>();
        orderRequest.getOrderLines().forEach(line -> {
            Product product = productMap.get(line.getProductId());
            if (product == null) {
                throw new IllegalArgumentException("Product not found with ID: " + line.getProductId());
            }

            InvoiceItemDto invoiceItemDto = new InvoiceItemDto(
                    product.getProductName(),
                    line.getPrice(),
                    line.getQty(),
                    line.getPrice() * line.getQty()
            );
            invoiceItemDtos.add(invoiceItemDto);
        });

        invoiceDto.setInvoiceItemDto(invoiceItemDtos);
        return invoiceDto;
    }
}
