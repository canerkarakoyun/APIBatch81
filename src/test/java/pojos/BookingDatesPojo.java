package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDatesPojo {
    // 1. Tum keyler icin private variable'lar olusturuyoruz
    private String checkin;
    private String checkout;

    // 2. Paramatreler icin constructor olusturuyoruz (bir de parametresiz olusturuyoruz)
    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public BookingDatesPojo() {
    }

    // 3. Public Getter ve Setter methodlarimizi olusturuyoruz


    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    // 4. Pojo class'i yazdirmak ve gormek icin toString() methodu olusturuyoruz

    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
