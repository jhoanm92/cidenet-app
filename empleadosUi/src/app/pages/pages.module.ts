import { ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from './../material/material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';


import { PagesRoutingModule } from './pages-routing.module';
import { EmployeeControlComponent } from './employee-control/employee-control.component';
import { EmployeeRegisterComponent } from './employee-register/employee-register.component';
import { LazybuttonComponent } from './lazybutton/lazybutton.component';


@NgModule({
  declarations: [
    EmployeeControlComponent,
    EmployeeRegisterComponent,
    LazybuttonComponent,
  ],
  imports: [
    CommonModule,
    PagesRoutingModule,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule,
  ]
})
export class PagesModule { }
