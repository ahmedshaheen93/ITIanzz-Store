package eg.gov.iti.jets.service.impl;

import java.util.Objects;

import eg.gov.iti.jets.model.Store;
import eg.gov.iti.jets.repository.impl.StoreRepositoryImpl;
import eg.gov.iti.jets.service.StoreService;

public class StoreServiceImpl implements StoreService {


    private static StoreServiceImpl instance;

    StoreRepositoryImpl storeRepository;

    protected StoreServiceImpl() {
        this.storeRepository = StoreRepositoryImpl.getInstance();
    }

    public static synchronized StoreServiceImpl getInstance() {
        instance = Objects.requireNonNullElseGet(instance, StoreServiceImpl::new);
        return instance;
    }

    @Override
    public Store getStoreInfo() {
        return storeRepository.getStoreInfo();
    }

    @Override
    public void updateStoreInfo(Store store) {
        storeRepository.updateStoreInfo(store);
    }
    
}
