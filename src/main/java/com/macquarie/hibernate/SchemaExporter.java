package com.macquarie.hibernate;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.PostgreSQL95Dialect;
import org.hibernate.dialect.PostgresPlusDialect;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.List;

import static org.hibernate.cfg.AvailableSettings.DEFAULT_SCHEMA;
import static org.hibernate.cfg.AvailableSettings.DIALECT;
import static org.hibernate.cfg.AvailableSettings.PHYSICAL_NAMING_STRATEGY;


public class SchemaExporter {

    public static void main(String[] args) {
        exportDDL("out.ddl", "public", PostgreSQL95Dialect.class,
                "com.macquarie.dimension.domain");
    }

    private static void exportDDL(String outputFile, String defaultSchema, Class<?> dialectClass, String... packagesToScan) {
        try {
            Files.deleteIfExists(Paths.get(outputFile));
        } catch (IOException e) {
            throw new RuntimeException("Unable to delete existing outputFile:" + outputFile);
        }

        SchemaExport se = new SchemaExport();
        se.setOutputFile(outputFile);
        MetadataSources ms = new MetadataSources(new StandardServiceRegistryBuilder()
                .applySetting(DEFAULT_SCHEMA, defaultSchema)
                .applySetting(PHYSICAL_NAMING_STRATEGY, SpringPhysicalNamingStrategy.class.getName())
                .applySetting(DIALECT, dialectClass.getName())
                .build());
        List<Class<?>> entities = EntityScanner.scanPackages(packagesToScan).result();
        entities.forEach(ms::addAnnotatedClass);
        se.setFormat(true);
        se.create(EnumSet.of(TargetType.SCRIPT), ms.buildMetadata());
    }
}
