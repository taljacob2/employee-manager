import {Component, OnInit} from '@angular/core';
import {Employee} from "./model/employee/employee";
import {EmployeeService} from "./service/employee/employee.service";
import {Settlement} from "./model/settlement/settlement";
import {SettlementService} from "./service/settlement/settlement.service";

@Component({
             selector   : 'app-root',
             templateUrl: './app.component.html',
             styleUrls  : ['./app.component.css']
           })

export class AppComponent implements OnInit {
  public employees: Employee[] = [];
  public settlements: Settlement[] = [];

  constructor(private employeeService: EmployeeService,
              private settlementService: SettlementService) {}

  ngOnInit(): void {
    this.initGetEmployeesSubscription();
    this.initGetSettlementsSubscription();
  }

  private async initGetEmployeesSubscription(): Promise<void> {
    try {
      this.employees = await this.employeeService.getEmployees();
    } catch (e) {
      alert(e.message);
    }
  }

  private async initGetSettlementsSubscription(): Promise<void> {
    try {
      this.settlements = await this.settlementService.getSettlements();
    } catch (e) {
      alert(e.message);
    }
  }

}
