package ru.mrchebik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mrchebik.model.ExampleModel;

/**
 * Created by mrchebik on 03.03.17.
 */
@Repository
public interface ExampleRepository extends JpaRepository<ExampleModel, Long> {
}
