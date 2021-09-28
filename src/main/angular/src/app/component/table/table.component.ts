import {Component, Input, OnInit} from '@angular/core';
import {Employee} from "../../model/employee/employee";
import {Settlement} from "../../model/settlement/settlement";

@Component({
             selector   : 'app-table',
             templateUrl: './table.component.html',
             styleUrls  : ['./table.component.css']
           })

export class TableComponent implements OnInit {

  @Input()
  public employees!: Employee[];

  @Input()
  public settlements!: Settlement[];

  constructor() {}

  ngOnInit(): void {}

}
