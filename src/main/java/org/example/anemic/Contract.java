package org.example.anemic;

import org.example.BrandId;
import org.example.ContractId;
import org.example.PartnerId;
import org.example.Percentage;

// BAD!!! This is an anemic domain model
public class Contract {

    public enum ContractStatus {
        PROPOSED, ACCEPTED, INACTIVE
    }

    private ContractId id;

    private BrandId brandId;
    private PartnerId partnerId;

    private ContractStatus status;

    private Percentage commissionPercentage;

    public ContractStatus getStatus() {
        return status;
    }

    public void setStatus(ContractStatus status) {
        this.status = status;
    }

    public Percentage getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(Percentage commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    public ContractId getId() {
        return id;
    }

    public void setId(ContractId id) {
        this.id = id;
    }

    public BrandId getBrandId() {
        return brandId;
    }

    public void setBrandId(BrandId brandId) {
        this.brandId = brandId;
    }

    public PartnerId getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(PartnerId partnerId) {
        this.partnerId = partnerId;
    }
}
