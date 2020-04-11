package eg.gov.iti.jets.repository;

import eg.gov.iti.jets.model.Store;

public interface StoreRepository extends Crud<Store, Long> {
    Store getStoreInfo();
    void updateStoreInfo(Store store);
}
