import { Pageable } from './../../core/model/pageable';
import { DialogConfirmacionComponent } from './../../shared/componens/dialog-confirmacion/dialog-confirmacion.component';
import { EmployeeRegisterComponent } from './../employee-register/employee-register.component';
import { EmployeeService } from './../../core/service/employee.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Employee } from 'src/app/core/model/employee';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatSort } from '@angular/material/sort';
import { MatPaginator, PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-employee-control',
  templateUrl: './employee-control.component.html',
  styleUrls: ['./employee-control.component.css']
})
export class EmployeeControlComponent implements OnInit {
  displayedColumns: string[] = [
    'name',
    'surname',
    'extraName',
    'country',
    'email',
    'acciones'
  ];

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  employees: Employee[] = [];
  pageable: Pageable = new Pageable();

  dataSource: MatTableDataSource<Employee> = new MatTableDataSource<Employee>(this.employees)

  constructor(
    private _employeeService: EmployeeService,
    private _dialog: MatDialog,
    private _snackBar: MatSnackBar,
  ) { }

  ngOnInit(): void {
    this.getAllEmployeesPage();
    this._employeeService.getListaCambio().subscribe(() => { this.getAllEmployees() });
  }

  getAllEmployees() {
    this._employeeService.getAll().subscribe(data => {
      this.employees = data;
      this.dataSource = new MatTableDataSource(this.employees)
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
    });
  }

  getAllEmployeesPage() {
    this._employeeService.getPageAll(this.pageable).subscribe(data => {
      this.employees = data.content;
      this.dataSource = new MatTableDataSource(this.employees)

      this.pageable.totalElements = data.totalElements
      this.pageable.size = data.size
      this.pageable.page = data.number
    });
  }

  openDialog() {
    this._dialog.open(EmployeeRegisterComponent, {
      height: '430px',
      width: '500px',
    });

  }

  eliminar(id: number) {
    let dialogRef = this._dialog.open(DialogConfirmacionComponent, {
      data: "¿Está seguro de que desea eliminar el empleado?"
    });

    dialogRef.afterClosed().subscribe(res => {
      if (res) {
        this._employeeService.delete(id).subscribe(() => {
          this.getAllEmployeesPage();
          this._snackBar.open("Empleado Eliminado", "✔️", {
            duration: 2000,
            verticalPosition: "top",
            horizontalPosition: "right"
          });
        });
      }
      return
    });
  }

  paginate(event: PageEvent) {
    this.pageable.totalElements = event.length
    this.pageable.size = event.pageSize
    this.pageable.page = event.pageIndex
    this.getAllEmployeesPage();
  }

}
