import { Component, OnInit } from '@angular/core';
import { TechnosService, Techno, TechnoLight } from '../technos.service';

@Component({
  selector: 'dj-compare',
  templateUrl: './compare.component.html',
  styleUrls: ['./compare.component.less']
})
export class CompareComponent implements OnInit {

  public technoLights: Array<TechnoLight>;

  public selectedTechno: TechnoLight;

  constructor(private technosService: TechnosService) {
    this.technosService.getTechnos().subscribe((liste) => {
      this.technoLights = liste;
      console.log('technoLights', this.technoLights);
    });
  }

  ngOnInit() {
  }

  onSelect() {
    console.log(this.selectedTechno);
    this.technosService.getTechno(this.selectedTechno.id);
  }

}
