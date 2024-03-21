
import './App.css';
import { Routes,Route } from 'react-router-dom';
import Homepage from './Components/HomePage/Homepage';
import Authentication from './Components/Authentication/Authentication';

function App() {
  return (
    <div className="">
      <Routes>
        <Route path='/*' element={false?<Homepage/>:<Authentication/>}></Route>
      </Routes>
    </div>
  );
}

export default App;
