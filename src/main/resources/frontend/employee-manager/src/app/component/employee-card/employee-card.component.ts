import {Component, Input, OnInit} from '@angular/core';
import {Employee} from "../../model/employee/employee";

@Component({
             selector   : 'app-employee-card',
             templateUrl: './employee-card.component.html',
             styleUrls  : ['./employee-card.component.css']
           })

export class EmployeeCardComponent implements OnInit {

  @Input()
  public employee!: Employee;

  constructor() {}

  ngOnInit(): void {}

}
