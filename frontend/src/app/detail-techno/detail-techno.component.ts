import { Component, OnInit, Input } from '@angular/core';
import { Techno, TechnosService } from '../technos.service';

@Component({
  selector: 'dj-detail-techno',
  templateUrl: './detail-techno.component.html',
  styleUrls: ['./detail-techno.component.less']
})
export class DetailTechnoComponent implements OnInit {

  @Input()
  public selectedTechno: Techno;

  constructor() {
    console.log(this.selectedTechno);
   }

  ngOnInit() {
  }

}
