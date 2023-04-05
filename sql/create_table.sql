CREATE TABLE tourist (
                         id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL ,
                         name VARCHAR(60) NOT NULL UNIQUE ,
                         citizen_id VARCHAR(13) NOT NULL UNIQUE ,
                         allergies text ,
                         medical_note text
);

# CREATE TABLE insurance (
#                            id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL ,
#                            company_name VARCHAR(60) NOT NULL ,
#                            price float NOT NULL check ( price >= 0 )
# );

CREATE TABLE province (
                          id int(2) PRIMARY KEY NOT NULL ,
                          name VARCHAR(60) NOT NULL
);

CREATE TABLE quotation (
                           id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL ,
                           real_price float NOT NULL check ( real_price >= 0 ),
                           status int(1) DEFAULT 0 CHECK ( status IN (0,1,9))
);

CREATE TABLE transportation (
                                id int(2) PRIMARY KEY AUTO_INCREMENT NOT NULL ,
                                price float NOT NULL check ( price >= 0 ) ,
                                type int(2) NOT NULL
);

CREATE TABLE hotel (
                       id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL ,
                       fk_province_id int(2) NOT NULL ,
                       name text NOT NULL ,
                       price float NOT NULL check ( price >= 0 ),
                       type int(2) check ( type >= 0 ),
                       rate int(1) NOT NULL check ( rate in (0,1,2,3,4,5) ),
                       FOREIGN KEY (fk_province_id) REFERENCES province (id)
                           ON DELETE CASCADE
                           ON UPDATE NO ACTION
);

CREATE TABLE tour (
                      id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL ,
                      fk_province_id int(2) NOT NULL ,
                      fk_quotation_id INTEGER NOT NULL ,
#                       fk_insurance_id INTEGER ,
                      contact_name VARCHAR(60) NOT NULL ,
                      contact_phone VARCHAR(10) NOT NULL ,
                      contact_email VARCHAR(50) NOT NULL ,
                      status int(1) NOT NULL DEFAULT 0 CHECK ( status IN (0,1,9)) ,
#                       insurance_cost float NOT NULL DEFAULT 0 check ( insurance_cost >= 0 ),
                      insurance_status int(1) NOT NULL DEFAULT 0 CHECK ( insurance_status IN (0,1) ),
                      cost_price float NOT NULL check ( cost_price >= 0 ) ,
                      tourist_total int(3) NOT NULL check ( tourist_total > 0 ) ,
                      budget float NOT NULL check ( budget >= 0 ) ,
                      description text NOT NULL ,
                      start_date DATE NOT NULL ,
                      end_date DATE NOT NULL ,
                      FOREIGN KEY (fk_province_id) REFERENCES province (id)
                          ON DELETE CASCADE
                          ON UPDATE NO ACTION ,
                      FOREIGN KEY (fk_quotation_id) REFERENCES quotation (id)
                          ON DELETE CASCADE
                          ON UPDATE NO ACTION
#                       FOREIGN KEY (fk_insurance_id) REFERENCES insurance (id)
#                           ON DELETE CASCADE
#                           ON UPDATE NO ACTION
);

CREATE TABLE tour_tourist (
                              fk_tour_id INTEGER NOT NULL ,
                              fk_tourist_id INTEGER NOT NULL ,
                              FOREIGN KEY (fk_tour_id) REFERENCES tour (id)
                                  ON DELETE CASCADE
                                  ON UPDATE NO ACTION ,
                              FOREIGN KEY (fk_tourist_id) REFERENCES tourist (id)
                                  ON DELETE CASCADE
                                  ON UPDATE NO ACTION
);

CREATE TABLE tour_hotel (
                            fk_tour_id INTEGER NOT NULL ,
                            fk_hotel_id INTEGER NOT NULL ,
                            cost_withholding float NOT NULL check ( cost_withholding >= 0 ),
                            FOREIGN KEY (fk_tour_id) REFERENCES tour (id)
                                ON DELETE CASCADE
                                ON UPDATE NO ACTION ,
                            FOREIGN KEY (fk_hotel_id) REFERENCES hotel (id)
                                ON DELETE CASCADE
                                ON UPDATE NO ACTION
);

CREATE TABLE tour_transportation (
                                     fk_tour_id INTEGER NOT NULL ,
                                     fk_transportation_id INTEGER NOT NULL ,
                                     cost_withholding float NOT NULL check ( cost_withholding >= 0 ),
                                     FOREIGN KEY (fk_tour_id) REFERENCES tour (id)
                                         ON DELETE CASCADE
                                         ON UPDATE NO ACTION ,
                                     FOREIGN KEY (fk_transportation_id) REFERENCES transportation (id)
                                         ON DELETE CASCADE
                                         ON UPDATE NO ACTION
);