package br.com.fiap.prontuarioms.gateway.config;

import br.com.fiap.prontuarioms.gateway.AlertGateway;
import br.com.fiap.prontuarioms.gateway.AllergyGateway;
import br.com.fiap.prontuarioms.gateway.MedicalCertificateGateway;
import br.com.fiap.prontuarioms.gateway.VaccineGateway;
import br.com.fiap.prontuarioms.gateway.database.jpa.AlertJpaGateway;
import br.com.fiap.prontuarioms.gateway.database.jpa.AllergyJpaGateway;
import br.com.fiap.prontuarioms.gateway.database.jpa.MedicalCertificateJpaGateway;
import br.com.fiap.prontuarioms.gateway.database.jpa.VaccineJpaGateway;
import br.com.fiap.prontuarioms.gateway.database.jpa.repository.AlertJpaRepository;
import br.com.fiap.prontuarioms.gateway.database.jpa.repository.AllergyJpaRepository;
import br.com.fiap.prontuarioms.gateway.database.jpa.repository.MedicalCertificateJpaRepository;
import br.com.fiap.prontuarioms.gateway.database.jpa.repository.VaccineJpaRepository;
import br.com.fiap.prontuarioms.usecase.alergia.CreateAllergyUseCase;
import br.com.fiap.prontuarioms.usecase.alergia.DeleteAllergyUseCase;
import br.com.fiap.prontuarioms.usecase.alergia.GetDataAllergyUseCase;
import br.com.fiap.prontuarioms.usecase.alergia.UpdateAllergyUseCase;
import br.com.fiap.prontuarioms.usecase.alerta.CreateAlertUseCase;
import br.com.fiap.prontuarioms.usecase.alerta.DeleteAlertUseCase;
import br.com.fiap.prontuarioms.usecase.alerta.GetDataAlertUseCase;
import br.com.fiap.prontuarioms.usecase.alerta.UpdateAlertUseCase;
import br.com.fiap.prontuarioms.usecase.atestado.CreateMedicalCertificateUseCase;
import br.com.fiap.prontuarioms.usecase.atestado.DeleteMedicalCertificateUseCase;
import br.com.fiap.prontuarioms.usecase.atestado.GetDataMedicalCertificateUseCase;
import br.com.fiap.prontuarioms.usecase.atestado.UpdateMedicalCertificateUseCase;
import br.com.fiap.prontuarioms.usecase.vacina.CreateVaccineUseCase;
import br.com.fiap.prontuarioms.usecase.vacina.DeleteVaccineUseCase;
import br.com.fiap.prontuarioms.usecase.vacina.GetDataVaccineUseCase;
import br.com.fiap.prontuarioms.usecase.vacina.UpdateVaccineUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    AllergyGateway allergyGateway(AllergyJpaRepository allergyJpaRepository) {
        return new AllergyJpaGateway(allergyJpaRepository);
    }

    @Bean
    CreateAllergyUseCase createAllergyUseCase(AllergyGateway allergyGateway) {
        return new CreateAllergyUseCase(allergyGateway);
    }

    @Bean
    DeleteAllergyUseCase deleteAllergyUseCase(AllergyGateway allergyGateway) {
        return new DeleteAllergyUseCase(allergyGateway);
    }

    @Bean
    GetDataAllergyUseCase getDataAllergyUseCase(AllergyGateway allergyGateway) {
        return new GetDataAllergyUseCase(allergyGateway);
    }

    @Bean
    UpdateAllergyUseCase updateAllergyUseCase(AllergyGateway allergyGateway) {
        return new UpdateAllergyUseCase(allergyGateway);
    }

    @Bean
    AlertGateway alertGateway(AlertJpaRepository alertJpaRepository) {
        return new AlertJpaGateway(alertJpaRepository);
    }

    @Bean
    CreateAlertUseCase createAlertUseCase(AlertGateway alertGateway) {
        return new CreateAlertUseCase(alertGateway);
    }

    @Bean
    GetDataAlertUseCase getDataAlertUseCase(AlertGateway alertGateway) {
        return new GetDataAlertUseCase(alertGateway);
    }

    @Bean
    UpdateAlertUseCase updateAlertUseCase(AlertGateway alertGateway) {
        return new UpdateAlertUseCase(alertGateway);
    }

    @Bean
    DeleteAlertUseCase deleteAlertUseCase(AlertGateway alertGateway) {
        return new DeleteAlertUseCase(alertGateway);
    }

    @Bean
    MedicalCertificateGateway medicalCertificateGateway(MedicalCertificateJpaRepository medicalCertificateJpaRepository) {
        return new MedicalCertificateJpaGateway(medicalCertificateJpaRepository);
    }

    @Bean
    CreateMedicalCertificateUseCase createMedicalCertificateUseCase(MedicalCertificateGateway medicalCertificateGateway) {
        return new CreateMedicalCertificateUseCase(medicalCertificateGateway);
    }

    @Bean
    GetDataMedicalCertificateUseCase getDataMedicalCertificateUseCase(MedicalCertificateGateway medicalCertificateGateway) {
        return new GetDataMedicalCertificateUseCase(medicalCertificateGateway);
    }

    @Bean
    UpdateMedicalCertificateUseCase updateMedicalCertificateUseCase(MedicalCertificateGateway medicalCertificateGateway) {
        return new UpdateMedicalCertificateUseCase(medicalCertificateGateway);
    }

    @Bean
    DeleteMedicalCertificateUseCase deleteMedicalCertificateUseCase(MedicalCertificateGateway medicalCertificateGateway) {
        return new DeleteMedicalCertificateUseCase(medicalCertificateGateway);
    }

    @Bean
    VaccineGateway vaccineGateway(VaccineJpaRepository vaccineJpaRepository) {
        return new VaccineJpaGateway(vaccineJpaRepository);
    }

    @Bean
    CreateVaccineUseCase createVaccineUseCase(VaccineGateway vaccineGateway) {
        return new CreateVaccineUseCase(vaccineGateway);
    }

    @Bean
    GetDataVaccineUseCase getDataVaccineUseCase(VaccineGateway vaccineGateway) {
        return new GetDataVaccineUseCase(vaccineGateway);
    }

    @Bean
    UpdateVaccineUseCase updateVaccineUseCase(VaccineGateway vaccineGateway) {
        return new UpdateVaccineUseCase(vaccineGateway);
    }

    @Bean
    DeleteVaccineUseCase deleteVaccineUseCase(VaccineGateway vaccineGateway) {
        return new DeleteVaccineUseCase(vaccineGateway);
    }

}
