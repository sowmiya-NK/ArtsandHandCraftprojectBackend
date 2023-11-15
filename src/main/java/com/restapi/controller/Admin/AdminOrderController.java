package com.restapi.controller.Admin;

import com.restapi.model.OrderStatus;
import com.restapi.model.Role;
import com.restapi.request.OrderStatusRequest;
import com.restapi.response.OrderResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/admin/order")
@RolesAllowed(Role.ADMIN)
public class AdminOrderController {
    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private OrderService orderService;

    //view all orders
    @GetMapping("/all")
    private ResponseEntity<APIResponse> getAllOrders(){
        List<OrderResponse> orderResponseList=orderService.getAllOrders();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(orderResponseList);
        return  new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    //view particular user order
    @GetMapping("/{userId}")
    private  ResponseEntity<APIResponse> getUsersOrder(@PathVariable Long userId){
        List<OrderResponse> orderResponseList=orderService.getUserOrders(userId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(orderResponseList);
        return  new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    //view allstatus
    @GetMapping("/status/all")
    private ResponseEntity<APIResponse> getAllStatus(){
        List<OrderStatus> orderStatusList=orderService.getAllOrderStatus();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(orderStatusList);
        return  new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    //update status
    @PutMapping("/status")
    private  ResponseEntity<APIResponse> updateOrderStatus(@RequestBody OrderStatusRequest orderStatusRequest){
        List<OrderResponse> orderResponseList=orderService.updateOrderStatus(orderStatusRequest.getOrderId(),orderStatusRequest.getStatusId());
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(orderResponseList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }



}
