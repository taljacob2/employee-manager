import {Component, Input, OnInit} from '@angular/core';
import {Settlement} from "../../model/settlement/settlement";
import {Employee} from "../../model/employee/employee";
import {EmployeeService} from "../../service/employee/employee.service";

@Component({
             selector   : 'inesrt-employee-dialog',
             templateUrl: './insert-employee-dialog.component.html',
             styleUrls  : ['./insert-employee-dialog.component.css']
           })

export class InsertEmployeeDialogComponent implements OnInit {

  public display: boolean = false;

  employeeToEdit = new Employee();

  @Input()
  public settlements!: Settlement[];

  constructor(private employeeService: EmployeeService) {}

  ngOnInit() {}

  public showDialog() {
    this.display = true;
  }

  public onSubmitInsert(): void {
    this.closeDialog();
    this.insertEmployee();
  }

  public onSubmitCancel(): void {
    this.closeDialog();
  }

  public async insertEmployee(): Promise<void> {
    try {
      await this.employeeService.insertEmployee(this.employeeToEdit);
    } catch (e) {
      console.log(e);
    }
  }

  getSelectedSettlementEntity($event: Settlement) {
    if ($event) {
      this.employeeToEdit.settlementEntity = $event;
    }
  }

  private closeDialog(): void {
    this.display = false;
  }

}
