package CompositePattern.company;

public abstract class CompanyComponent {

    public String name;
    protected String phone;
    protected String email;

    public CompanyComponent(String name) {
        this.name = name;
    }

    public void addMember(CompanyComponent member) {
        throw new UnsupportedOperationException();
    };  // Employee에서 안쓰려고

    public abstract void display();

}
