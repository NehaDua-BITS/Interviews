package meesho.lld.payoutsystem.model;

public class Address {

    private String line1;

    private String line2;

    private String city;

    private String area;

    private String state;

    private String country;

    private String zipCode;

    public Address(String line1, String line2, String city, String area, String state, String country, String zipCode) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.area = area;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public static class AddressBuilder {

        private String line1;

        private String line2;

        private String city;

        private String area;

        private String state;

        private String country;

        private String zipCode;

        public AddressBuilder(String area, String zipCode) {
            this.area = area;
            this.zipCode = zipCode;
        }

        public AddressBuilder setLine1(String line1) {
            this.line1 = line1;
            return this;
        }

        public AddressBuilder setLine2(String line2) {
            this.line2 = line2;
            return this;
        }
        public AddressBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder setState(String state) {
            this.state = state;
            return this;
        }

        public AddressBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Address build() {
            return new Address(this.line1, this.line2, this.city, this.area, this.state, this.country, this.zipCode);
        }


    }

}
