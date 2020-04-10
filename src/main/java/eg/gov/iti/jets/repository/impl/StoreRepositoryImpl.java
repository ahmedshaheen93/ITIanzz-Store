package eg.gov.iti.jets.repository.impl;

import java.util.Objects;

import eg.gov.iti.jets.model.Store;
import eg.gov.iti.jets.repository.StoreRepository;

public class StoreRepositoryImpl extends CrudImpl<Store, Long> implements StoreRepository {

    private static StoreRepositoryImpl instance;

    private StoreRepositoryImpl() {
    }

    public static synchronized StoreRepositoryImpl getInstance() {
        instance = Objects.requireNonNullElseGet(instance, StoreRepositoryImpl::new);
        return instance;
    }

}
