This micro service is engaged of getting data from an api micro service that controls patients and relate that data whit a turn (shift).


Data of patients: dni, name, lastName, birthDate and phoneNumber.
Data of turn in db: shiftDate patientFullName and treatment.

When the shift is added is necessary to specify the dni, treatment and the date. The fullname of the patient is going to be consult using Rest Template.
