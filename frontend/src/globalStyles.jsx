import { createGlobalStyle } from 'styled-components';
const GlobalStyle = createGlobalStyle`
    :root{
        --textPrimary:#1C1D1F;
        --textSecondary:#A435F0;
        --bgColor:#FFFFFF;
    }
  body {
    margin: 0;
    padding: 0;
background:var(--bgColor);     
  }
`;
export default GlobalStyle;