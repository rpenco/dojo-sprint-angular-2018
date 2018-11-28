import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { TitleComponent } from './title/title.component';
import { MenuComponent } from './menu/menu.component';
import { ContentComponent } from './content/content.component';
import { FooterComponent } from './footer/footer.component';

import { TechnosService } from './technos.service';
import { HttpClientModule } from '@angular/common/http';
import { CompareComponent } from './compare/compare.component';
import { CreateComponent } from './create/create.component';
import { GraphsComponent } from './graphs/graphs.component';
import { DetailTechnoComponent } from './detail-techno/detail-techno.component';


@NgModule({
  declarations: [
    AppComponent,
    TitleComponent,
    MenuComponent,
    ContentComponent,
    FooterComponent,
    CompareComponent,
    CreateComponent,
    GraphsComponent,
    DetailTechnoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [TechnosService],
  bootstrap: [AppComponent]
})
export class AppModule { }
