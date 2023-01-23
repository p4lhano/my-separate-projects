import { DiCss3, DiHtml5, DiJsBadge, DiNodejsSmall, DiPostgresql, DiReact } from 'react-icons/di'
import '../styles/components/TechnologiesContainer.sass'
import { ItensView } from '../types/ItensView'

const technologies: ItensView[] = [
    {nameKey: 'html',   icon: <DiHtml5 style={{color: '#E44D26'}} />},
    {nameKey: 'css',    icon: <DiCss3 style={{color: '#1572B6'}} />},
    {nameKey: 'js',     icon: <DiJsBadge style={{color: '#F0DB4F'}} />},
    {nameKey: 'node',   icon: <DiNodejsSmall style={{color: '#83CD29'}} />},
    {nameKey: 'postgres',icon: <DiPostgresql style={{color: '#008bb9'}} />},
    {nameKey: 'react',  icon: <DiReact style={{color: '#61DAFB'}} />},
]

export default function TechnologiesContainer() {
  return (
    <section id="technologies-container">
        <h2>Stack Tecnológica</h2>
        <div id="technologies-grid">
            {technologies.map( tech => (
                <div className='technologies-card' id={tech.nameKey} key={tech.nameKey}>
                    {tech.icon}
                    <h3>{tech.nameKey}</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.</p>
                </div>
            ))}
        </div>
    </section>
  )
}
