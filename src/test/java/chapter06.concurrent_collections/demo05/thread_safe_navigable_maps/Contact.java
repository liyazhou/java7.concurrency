package chapter06.concurrent_collections.demo05.thread_safe_navigable_maps;

/**
 * �洢��navigable map�е�һ����ϵ��
 **/
public class Contact {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

}
