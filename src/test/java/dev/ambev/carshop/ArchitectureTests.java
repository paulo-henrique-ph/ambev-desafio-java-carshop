package dev.ambev.carshop;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;


public class ArchitectureTests {
    JavaClasses importedClasses = new ClassFileImporter().importPackages("dev.ambev.carshop");

    @Test
    public void verifyCyclicClassDependencies() {
        ArchRule rule = slices().matching("dev.ambev.carshop.(*)..").should().beFreeOfCycles();

        rule.check(importedClasses);
    }

    @Test
    public void verifyLayerViolation() {
        ArchRule rule = layeredArchitecture()
                .consideringAllDependencies()
                // Define layers
                .layer("Controller").definedBy("..controller.(*)..")
                .layer("Service").definedBy("..service..")
                .layer("Repository").definedBy("..repository..")
                // Add constraints
                .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
                .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service");

        rule.check(importedClasses);
    }

    @Test
    public void verifyClassNamesOnPersistenceLayer() {
        ArchRule rule = classes().that().haveSimpleNameEndingWith("Dto").should().resideInAPackage("..dto..");

        rule.check(importedClasses);
    }
}
