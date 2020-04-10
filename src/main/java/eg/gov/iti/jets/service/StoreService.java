package eg.gov.iti.jets.service;

import eg.gov.iti.jets.model.Store;

public interface StoreService {
    Store getStoreInfo();
    void updateStoreInfo(Store store);
}
