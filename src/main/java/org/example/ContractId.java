package org.example;

import java.util.UUID;


public class ContractId extends BaseEntityId {

    private ContractId(UUID id) {
        super(id);
    }

    public static ContractId newId() {
        return new ContractId(UUID.randomUUID());
    }

}
