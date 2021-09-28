import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Settlement} from "../../model/settlement/settlement";

@Component({
             selector   : 'app-auto-complete',
             templateUrl: './auto-complete.component.html',
             styleUrls  : ['./auto-complete.component.css']
           })

export class AutoCompleteComponent implements OnInit {

  public selectableSettlements: Settlement[] = [];

  @Output()
  public selectedSettlementEvent = new EventEmitter<Settlement>();

  @Input()
  public selectedSettlement!: Settlement;

  @Input()
  public settlements!: Settlement[];

  constructor() {}

  public outputToParent() {
    this.selectedSettlementEvent.emit(this.selectedSettlement);
  }

  ngOnInit(): void {this.selectableSettlements = this.settlements;}

  public searchSettlement(event: any): void {

    // Filter `selectableSettlements`
    this.selectableSettlements = this.filterSettlementsByName(event.query);

    // Auto update `selectedSettlement` if a Settlement found
    if (this.selectableSettlements.length === 1) {
      this.selectedSettlement = this.selectableSettlements[0];
    }

    this.outputToParent();
  }

  private filterSettlementsByName(query: string): Settlement[] {
    return this.settlements!.filter(value => {
      return value.name.toLowerCase().includes(query.toLowerCase());
    });
  }

}
