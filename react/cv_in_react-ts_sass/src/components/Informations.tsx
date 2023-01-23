import { Component } from 'react';
import { AiFillEnvironment, AiFillPhone, AiOutlineMail } from 'react-icons/ai';
import '../styles/components/Informations.sass';
import { ItensView as InformationItem } from '../types/ItensView';

const informations: InformationItem[] = [
    {icon: <AiFillPhone id='phone-icon' />, nameKey: 'telefone', ref: '+55 41 99633-5631'},
    {icon: <AiOutlineMail id='email-icon' /> , nameKey: 'e-mail', ref: 'vitorpalhano2014@gmail.com'},
    {icon: <AiFillEnvironment id="pin-icon"/>, nameKey: 'localização', ref: 'Curitiba / PR'}

]

export default class Informations extends Component {
  render() {
    return (
      <section id="information">
        {informations.map(
            info => (
            <div className='info-card'>
                {info.icon}
                <div>
                    <h3>{info.nameKey}</h3>
                    <p>{info.ref}</p>
                </div>
            </div>
            )
        )}
      </section>
    )
  }
}
