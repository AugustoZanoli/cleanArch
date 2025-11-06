package br.com.clean.core.domain;

import br.com.clean.core.exception.TransactionPinException;
import br.com.clean.core.exception.enums.ErrorCodeEnum;

import java.time.LocalDateTime;
import java.util.Objects;

public class TransactionPin {
    private Long id;

    private Wallet wallet;

    private String pin;

    private Integer attempt;

    private Boolean blocked;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public TransactionPin(Long id, Wallet wallet, String pin, Integer attempt, Boolean blocked, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.wallet = wallet;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TransactionPin(String pin) throws TransactionPinException {
        setPin(pin);
        this.attempt = 3;
        this.blocked = false;
        this.createdAt = LocalDateTime.now();
    }

    public TransactionPin() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) throws TransactionPinException{
        pinIsValid(pin);
        this.pin = pin;
    }

    private void pinIsValid(String pin) throws TransactionPinException{
        if (!Objects.equals(pin.length(), 8)) {
            throw new TransactionPinException(ErrorCodeEnum.TRP0001.getMessage(), ErrorCodeEnum.TRP0001.getCode());
        }
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        TransactionPin that = (TransactionPin) object;
        return Objects.equals(id, that.id) && Objects.equals(wallet, that.wallet) && Objects.equals(pin, that.pin) && Objects.equals(attempt, that.attempt) && Objects.equals(blocked, that.blocked) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wallet, pin, attempt, blocked, createdAt, updatedAt);
    }
}
