import { EmployeeControlComponent } from './employee-control/employee-control.component';
import { EmployeeRegisterComponent } from './employee-register/employee-register.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'employee-control', component: EmployeeControlComponent },
  { path: 'employee-register', component: EmployeeRegisterComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PagesRoutingModule { }
