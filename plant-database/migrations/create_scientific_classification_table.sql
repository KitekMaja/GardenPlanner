/*
 * Filename: create_scientific_classification_table.sql
 * Description: Creates the 'scientific_classification' table in the 'plant' database
 * Author: Maja Kitek
 * Date: 2023-04-28
 */

CREATE TABLE scientific_classification (
  classification_id SERIAL PRIMARY KEY,
  fk_genus_id SERIAL NOT NULL,
  fk_family_id SERIAL NOT NULL,
  fk_order_id SERIAL NOT NULL,
  fk_class_id SERIAL NOT NULL,
  fk_phylum_id SERIAL NOT NULL,
  CONSTRAINT fk_genus_id FOREIGN KEY (fk_genus_id) REFERENCES genus (genus_id) ON DELETE CASCADE, 
  CONSTRAINT fk_family_id FOREIGN KEY (fk_family_id) REFERENCES family (family_id) ON DELETE CASCADE, 
  CONSTRAINT fk_order_id FOREIGN KEY (fk_order_id) REFERENCES plant_order (order_id) ON DELETE CASCADE, 
  CONSTRAINT fk_class_id FOREIGN KEY (fk_class_id) REFERENCES class (class_id) ON DELETE CASCADE, 
  CONSTRAINT fk_phylum_id FOREIGN KEY (fk_phylum_id) REFERENCES phylum (phylum_id) ON DELETE CASCADE
 );