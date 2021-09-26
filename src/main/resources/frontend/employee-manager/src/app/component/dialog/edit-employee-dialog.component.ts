import {Component, Input, OnInit} from '@angular/core';
import {Settlement} from "../../model/settlement/settlement";
import {Employee} from "../../model/employee/employee";
import {EmployeeService} from "../../service/employee/employee.service";
import {SettlementService} from "../../service/settlement/settlement.service";
import {NgForm} from "@angular/forms";

@Component({
             selector   : 'edit-employee-dialog',
             templateUrl: './edit-employee-dialog.component.html',
             styleUrls  : ['./edit-employee-dialog.component.css']
           })

export class EditEmployeeDialogComponent implements OnInit {

  editNgForm!: NgForm;

  public display: boolean = false;

  @Input()
  employeeToEdit!: Employee;

  @Input()
  public settlements!: Settlement[];

  constructor(private employeeService: EmployeeService,
              private settlementService: SettlementService) {}

  ngOnInit() {}

  public showDialog() {
    this.display = true;
  }

  public onSubmitSave(): void {
    this.closeDialog();
    this.saveEmployee();
  }

  public onSubmitDelete(): void {
    this.closeDialog();
    this.deleteEmployee();
  }

  public onSubmitCancel(): void {
    this.closeDialog();
  }

  public async saveEmployee(): Promise<void> {
    try {
      await this.employeeService.updateEmployee(this.employeeToEdit);
    } catch (e) {
      console.log(e);
    }
  }

  public async deleteEmployee(): Promise<void> {
    try {
      await this.employeeService.deleteEmployee(this.employeeToEdit.id);
    } catch (e) {
      console.log(e);
    }
  }

  public getSelectedSettlementEntity($event: Settlement): void {
    if ($event) {
      this.employeeToEdit.settlementEntity = $event;
    }
  }

  private async getSettlement(): Promise<Settlement> {
    return await this.settlementService.getSettlement(
      this.employeeToEdit.settlementEntity.id);
  }

  private closeDialog(): void {
    this.display = false;
  }

}
