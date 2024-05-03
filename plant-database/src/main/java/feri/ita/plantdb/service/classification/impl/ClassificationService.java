package feri.ita.plantdb.service.classification.impl;

import feri.ita.plantdb.dao.classification.*;
import feri.ita.plantdb.dto.classification.ClassificationDTO;
import feri.ita.plantdb.model.classification.ClassificationModel;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClassificationService {

    private final IClassificationRepository classificationRepository;
    private final IClassRepository classRepository;
    private final IFamilyRepository familyRepository;
    private final IGenusRepository genusRepository;
    private final IOrderRepository orderRepository;
    private final IPhylumRepository phylumRepository;

    public ClassificationService(IClassificationRepository classificationRepository, IClassRepository classRepository,
                                 IFamilyRepository familyRepository, IGenusRepository genusRepository,
                                 IOrderRepository orderRepository, IPhylumRepository phylumRepository) {
        this.classificationRepository = classificationRepository;
        this.classRepository = classRepository;
        this.familyRepository = familyRepository;
        this.genusRepository = genusRepository;
        this.orderRepository = orderRepository;
        this.phylumRepository = phylumRepository;
    }

    private ClassificationDTO convertToDTO(ClassificationModel classificationModel) {
        ClassificationModel classificationDTO = new ClassificationModel();
        //classificationDTO.set(classificationModel.getClassName());
        //return classDTO;
        return null;
    }

    private ClassificationModel convertDTOToModel(ClassificationDTO classificationDTO) {
        ClassificationModel classificationModel = new ClassificationModel();
        Long uniqueId = Math.abs(UUID.randomUUID().getLeastSignificantBits());
        classificationModel.setClassificationId(uniqueId);
        classificationModel.setClazz(classRepository.getClassByName(classificationDTO.getClassName()));
        classificationModel.setFamily(familyRepository.getFamilyByName(classificationDTO.getFamilyName()));
        classificationModel.setGenus(genusRepository.getGenusByName(classificationDTO.getGenusName()));
        classificationModel.setOrder(orderRepository.getOrderByName(classificationDTO.getOrderName()));
        classificationModel.setPhylum(phylumRepository.getPhylumByName(classificationDTO.getPhylumName()));
        return classificationModel;
    }
}
