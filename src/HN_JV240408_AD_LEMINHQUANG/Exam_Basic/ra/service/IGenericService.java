package HN_JV240408_AD_LEMINHQUANG.Exam_Basic.ra.service;

import java.util.List;

public interface IGenericService <T,E>{
    List<T> getAll ();
    void save(T t);
    int findById(E id);
    void delete(E id);
}
