package com.algaworks.crudcobranca.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @NotEmpty(message = "Por favor informar a descrição.")
    @Size(max = 60, message = "A mensagem deve ter no máximo 60 caracteres.")
    private String description;

    @NotNull(message = "Obrigatório informar data de vencimento.")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    @NotNull(message = "Por favor informe o valor do título.")
    @DecimalMin(value = "0,01")
    @DecimalMax(value = "9999,99")
    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private StatusTitle status;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public StatusTitle getStatus() {
        return status;
    }

    public void setStatus(StatusTitle status) {
        this.status = status;
    }

    public boolean isPending() {
        return StatusTitle.PENDING.equals(this.status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Title)) return false;
        Title title = (Title) o;
        return Objects.equals(getCode(), title.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }
}
