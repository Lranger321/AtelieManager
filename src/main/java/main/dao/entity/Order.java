package main.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.common.OrderStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @ManyToOne
    private Model model;

    @OneToMany(mappedBy = "order")
    private List<Parameter> parameters;

    @OneToMany(mappedBy = "order")
    private List<Attribute> attributes;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
