package main.dao.entity;

import lombok.*;
import main.common.OrderStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

@ToString
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

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    private Model model;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Parameter> parameters;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
