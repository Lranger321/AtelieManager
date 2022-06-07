package main.dao.repository;

import main.common.OrderStatus;
import main.dao.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>, PagingAndSortingRepository<Order, Long> {

    Page<Order> findAllByStatus(OrderStatus status, Pageable pageable);

    List<Order> findAll();
}
