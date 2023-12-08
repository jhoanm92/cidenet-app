import { MatSnackBar } from '@angular/material/snack-bar';
import { DialogConfirmacionComponent } from './../../shared/componens/dialog-confirmacion/dialog-confirmacion.component';
import { MatDialogRef } from '@angular/material/dialog';
import { Employee } from 'src/app/core/model/employee';
import { Country } from './../../core/model/country';
import { CountryService } from './../../core/service/country.service';
import { EmployeeService } from './../../core/service/employee.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-employee-register',
  templateUrl: './employee-register.component.html',
  styleUrls: ['./employee-register.component.css']
})
export class EmployeeRegisterComponent implements OnInit {

  form: FormGroup;

  countries: Country[] = [];

  constructor(
    private _employeeService: EmployeeService,
    private _countryService: CountryService,
    private _formBuilder: FormBuilder,
    public _dialogRef: MatDialogRef<DialogConfirmacionComponent>,
    private _snackBar: MatSnackBar,
  ) { }

  ngOnInit(): void {
    this.getAllCountries();
    this.initForm();
  }

  getAllCountries() {
    this._countryService.getAll().subscribe(data => {
      this.countries = data;
    });
  }

  initForm() {
    this.form = this._formBuilder.group({
      name: [null, [Validators.required]],
      surname: [null, [Validators.required]],
      extraName: [null],
      country: [null, [Validators.required]],
    });
  }

  employeeRegister(){
    let employee: Employee = {
      id: 0,
      name: this.name.value,
      surname: this.surname.value,
      extraName: this.extraName.value,
      country: this.country.value,
      email: ''
    }

    this._employeeService.register(employee).subscribe(data => {
      console.log(data);
      this._employeeService.setListaCambio();
      this._snackBar.open("Empleado Registrado", "✔️", {
        duration: 2000,
        verticalPosition: "top",
        horizontalPosition: "right"
      });
      this._dialogRef.close(true);
    });
  }

  // ------------------------------ get form ------------------------------
  get name() {
    return this.form.get("name")!
  }

  get surname() {
    return this.form.get("surname")!
  }

  get extraName() {
    return this.form.get("extraName")!
  }

  get country() {
    return this.form.get("country")!
  }

  validateIsDirrection(caracter: any) {
    let texto = caracter.key;
    const exprReg = /[a-zA-Z]/;
    let centinel = exprReg.test(texto);
    return centinel;
  }

  validateIsDirrectionEspace(caracter: any) {
    let texto = caracter.key;
    const exprReg = /[a-zA-Z ]/;
    let centinel = exprReg.test(texto);
    return centinel;
  }

}
