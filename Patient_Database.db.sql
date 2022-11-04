BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "gender" (
	"genderID"	INTEGER,
	"patientID"	INTEGER,
	"gender"	TEXT,
	PRIMARY KEY("genderID" AUTOINCREMENT),
	FOREIGN KEY("patientID") REFERENCES "names"("patientID") on delete cascade
);
CREATE TABLE IF NOT EXISTS "names" (
	"patientID"	INTEGER,
	"firstName"	TEXT,
	"lastName"	TEXT,
	PRIMARY KEY("patientID" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "dob" (
	"dobID"	INTEGER,
	"patientID"	INTEGER,
	"dob"	TEXT,
	PRIMARY KEY("dobID" AUTOINCREMENT),
	FOREIGN KEY("patientID") REFERENCES "names"("patientID") on delete cascade
);
CREATE TABLE IF NOT EXISTS "addresses" (
	"addressID"	INTEGER,
	"patientID"	INTEGER,
	"address1"	TEXT,
	"address2"	TEXT,
	"city"	TEXT,
	"state"	TEXT,
	"zipcode"	INTEGER,
	PRIMARY KEY("addressID" AUTOINCREMENT),
	FOREIGN KEY("patientID") REFERENCES "names"("patientID") on delete cascade
);
CREATE TABLE IF NOT EXISTS "emailAddresses" (
	"emailID"	INTEGER,
	"patientID"	INTEGER,
	"emailAddresses"	TEXT,
	PRIMARY KEY("emailID" AUTOINCREMENT),
	FOREIGN KEY("patientID") REFERENCES "names"("patientID") on delete cascade
);
CREATE TABLE IF NOT EXISTS "phoneNumbers" (
	"phoneID"	INTEGER,
	"patientID"	INTEGER,
	"phoneNumber"	INTEGER,
	PRIMARY KEY("phoneID" AUTOINCREMENT),
	FOREIGN KEY("patientID") REFERENCES "names"("patientID") on delete cascade
);
CREATE TABLE IF NOT EXISTS "visits" (
	"visitID"	INTEGER,
	"patientID"	INTEGER,
	"arrivalDate"	TEXT,
	"dischargeDate"	TEXT,
	"reasonVisit"	TEXT,
	PRIMARY KEY("visitID" AUTOINCREMENT),
	FOREIGN KEY("patientID") REFERENCES "names"("patientID") on delete cascade
);
COMMIT;
