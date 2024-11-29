package org.example.rich;

import org.example.BrandId;
import org.example.ContractId;
import org.example.PartnerId;
import org.example.Percentage;
import org.javamoney.moneta.Money;

// GOOD!!! This is a rich domain model
public class Contract {

    private enum ContractStatus {
        PROPOSED, ACCEPTED, DEACTIVATED
    }

    private ContractId id;

    private BrandId brandId;
    private PartnerId partnerId;

    private ContractStatus status;

    private Percentage commissionPercentage;

    private Contract(BrandId brandId, PartnerId partnerId, Percentage commissionPercentage) {

        assertNotNull(brandId, "brandId cannot be null");
        assertNotNull(partnerId, "partnerId cannot be null");
        assertNotNull(commissionPercentage, "commissionPercentage cannot be null");

        validatePercentage(commissionPercentage);

        this.id = ContractId.newId();
        this.brandId = brandId;
        this.partnerId = partnerId;
        this.commissionPercentage = commissionPercentage;

        this.status = ContractStatus.PROPOSED;

    }

    public static Contract propose(BrandId brandId, PartnerId partnerId, Percentage commissionPercentage) {
        return new Contract(brandId, partnerId, commissionPercentage);
    }


    public void accept() {
        if (isProposed()) {
            throw new IllegalStateException("Contract can not be accepted");
        }
        status = ContractStatus.ACCEPTED;
    }


    public void deactivate() {
        if (!isAccepted()) {
            throw new IllegalStateException("Contract can not be deactivated");
        }
        status = ContractStatus.DEACTIVATED;
    }

    public Money commission(Money saleAmount) {
        if (!isAccepted()) {
            throw new IllegalStateException("Only accepted contracts can provide commission");
        }
        return null; // maybe something like commissionPercentage.of(saleAmount)
    }

    private boolean isAccepted() {
        return status == ContractStatus.ACCEPTED;
    }

    private boolean isProposed() {
        return status == ContractStatus.PROPOSED;
    }


    public ContractEssence essence() {
        return new ContractEssence(id, brandId, partnerId, status.name(), commissionPercentage);
    }

    public record ContractEssence(ContractId id, BrandId brandId, PartnerId partnerId, String statusDesc, Percentage commissionPercentage) {

    }

    private static void validatePercentage(Percentage commissionPercentage) {
        if (commissionPercentage.isLessThan(Percentage.ZERO) || commissionPercentage.isGreaterThan(Percentage.ONE_HUNDRED)) {
            throw new IllegalArgumentException("commissionPercentage must be between 0 and 100");
        }
    }


    private static void assertNotNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

}
