import { Component, OnInit } from '@angular/core';
import { TechnosService, TechnoLight } from '../technos.service';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'dj-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.less']
})
export class ContentComponent implements OnInit {

  public title: string;
  public technos: Array<TechnoLight>;
  public selectedTechno: TechnoLight;

  constructor(private technosService: TechnosService,
              private activatedRoute: ActivatedRoute) {

    this.activatedRoute.params.subscribe((params) => {
      console.log('activatedRoute:', params);
    });
    this.technosService.getTechnos().subscribe((liste) => {
      this.technos = liste;
      console.log('technos', this.technos);
    });
  }

  ngOnInit() {
  }

  showDetail(selectedTechno: TechnoLight) {
    this.technosService.getTechno(selectedTechno.id).subscribe((techno) => {
      this.selectedTechno = techno;
    });
  }


}
