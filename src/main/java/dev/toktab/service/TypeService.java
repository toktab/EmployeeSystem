package dev.toktab.service;

import dev.toktab.exception.ResourceException;
import dev.toktab.model.Type;
import dev.toktab.repository.SalaryHistoryRepository;
import dev.toktab.repository.TypeRepository;
import dev.toktab.service.interfaces.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService extends BaseService<Type> implements ITypeService {
    @Autowired
    public void setTypeRepository(TypeRepository typeRepository){
        super.setRepository(typeRepository);
    }
}
