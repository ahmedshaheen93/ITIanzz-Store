package eg.gov.iti.jets.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "IMAGES")
public class Image implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IMAGE_ID", nullable = false)
    private Long imageId;

    @Column(name = "IMAGE_NAME", nullable = false)
    private String imageName;

    @Column(name = "IMAGE_TYPE", nullable = false)
    private String imageType;

    @Column(name = "IMAGE_PATH", nullable = false)
    private String imagePath;

    public Image() {
    }

    public Image(String imageName, String imageType, String imagePath) {
        this.imageName = imageName;
        this.imageType = imageType;
        this.imagePath = imagePath;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}