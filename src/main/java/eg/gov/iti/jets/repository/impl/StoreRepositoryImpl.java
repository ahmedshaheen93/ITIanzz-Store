package eg.gov.iti.jets.repository.impl;

import java.util.List;
import java.util.Objects;

import eg.gov.iti.jets.model.Address;
import eg.gov.iti.jets.model.Image;
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

    @Override
    public Store getStoreInfo() {
        List<Store> stores = findAll();
        if (stores.size() > 1) {
            for (Store store : stores) {
                delete(store);
            }
            save(createNewStore());
        } else if(stores.size() < 1) {
            save(createNewStore());
        }
        return findAll().get(0);
    }

    @Override
    public void updateStoreInfo(Store updatedStore) {
        List<Store> stores = findAll();
        if (stores.size() > 1) {
            for (Store store : stores) {
                delete(store);
            }
            save(createNewStore());
        } else if(stores.size() < 1) {
            save(createNewStore());
        }
        updatedStore.setStoreId(findAll().get(0).getStoreId());
        save(updatedStore);
    }

    private Store createNewStore() {
        Store storeInstance = new Store();

        storeInstance.setStoreName("ITI Store");
        storeInstance.setDescription("This is where you can buy ITI souvniers to remember this place and the AMAZING people you've met.");
        storeInstance.setEmail("store@jets.iti.gov.eg");
        storeInstance.setPhoneNumber("+ 02 353 556 56");
        storeInstance.setFaxNumber("+ 02 353 556 56");
        
        Address address = new Address();
        address.setCountry("Egypt");
        address.setState("Cairo");
        address.setCity("6 October");
        address.setStreet("1st Street");
        address.setZipCode("12345");        
        storeInstance.setAddress(address);

        storeInstance.setFaceBook("https://www.facebook.com/");
        storeInstance.setTwitter("https://www.twitter.com/");
        storeInstance.setYoutube("https://www.youtube.com/");
        storeInstance.setLinkedin("https://www.linkedin.com/");
        storeInstance.setInstagram("https://www.instagram.com/");

        return storeInstance;
    }
}
