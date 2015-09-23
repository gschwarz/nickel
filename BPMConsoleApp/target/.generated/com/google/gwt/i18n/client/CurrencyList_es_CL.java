package com.google.gwt.i18n.client;

import com.google.gwt.i18n.client.impl.CurrencyDataImpl;
import com.google.gwt.core.client.JavaScriptObject;
import java.util.HashMap;

public class CurrencyList_es_CL extends com.google.gwt.i18n.client.CurrencyList_es {
  
  @Override
  protected CurrencyData getDefaultJava() {
    return new CurrencyDataImpl("CLP", "$", 0, "CL$");
  }
  
  @Override
  protected native CurrencyData getDefaultNative() /*-{
    return [ "CLP", "$", 0, "CL$"];
  }-*/;
  
  @Override
  protected HashMap<String, CurrencyData> loadCurrencyMapJava() {
    HashMap<String, CurrencyData> result = super.loadCurrencyMapJava();
    // peseta andorrana
    result.put("ADP", new CurrencyDataImpl("ADP", "ADP", 128));
    // dírham de los Emiratos Árabes Unidos
    result.put("AED", new CurrencyDataImpl("AED", "DH", 2, "DH"));
    // afgani (1927-2002)
    result.put("AFA", new CurrencyDataImpl("AFA", "AFA", 130));
    // afgani
    result.put("AFN", new CurrencyDataImpl("AFN", "Af", 0));
    // lek albanés
    result.put("ALL", new CurrencyDataImpl("ALL", "ALL", 0));
    // dram armenio
    result.put("AMD", new CurrencyDataImpl("AMD", "AMD", 0));
    // florín de las Antillas Neerlandesas
    result.put("ANG", new CurrencyDataImpl("ANG", "NAf.", 2));
    // kwanza angoleño
    result.put("AOA", new CurrencyDataImpl("AOA", "Kz", 2));
    // kwanza angoleño (1977-1990)
    result.put("AOK", new CurrencyDataImpl("AOK", "AOK", 130));
    // nuevo kwanza angoleño (1990-2000)
    result.put("AON", new CurrencyDataImpl("AON", "AON", 130));
    // kwanza reajustado angoleño (1995-1999)
    result.put("AOR", new CurrencyDataImpl("AOR", "AOR", 130));
    // austral argentino
    result.put("ARA", new CurrencyDataImpl("ARA", "₳", 130));
    // ARL
    result.put("ARL", new CurrencyDataImpl("ARL", "$L", 130));
    // ARM
    result.put("ARM", new CurrencyDataImpl("ARM", "m$n", 130));
    // peso argentino (1983-1985)
    result.put("ARP", new CurrencyDataImpl("ARP", "ARP", 130));
    // peso argentino
    result.put("ARS", new CurrencyDataImpl("ARS", "AR$", 2, "AR$"));
    // chelín austriaco
    result.put("ATS", new CurrencyDataImpl("ATS", "ATS", 130));
    // dólar australiano
    result.put("AUD", new CurrencyDataImpl("AUD", "AU$", 2, "AU$"));
    // florín de Aruba
    result.put("AWG", new CurrencyDataImpl("AWG", "Afl.", 2));
    // manat azerí (1993-2006)
    result.put("AZM", new CurrencyDataImpl("AZM", "AZM", 130));
    // manat azerí
    result.put("AZN", new CurrencyDataImpl("AZN", "man.", 2));
    // dinar bosnio
    result.put("BAD", new CurrencyDataImpl("BAD", "BAD", 130));
    // marco convertible de Bosnia-Herzegovina
    result.put("BAM", new CurrencyDataImpl("BAM", "KM", 2));
    // dólar de Barbados
    result.put("BBD", new CurrencyDataImpl("BBD", "Bds$", 2));
    // taka de Bangladesh
    result.put("BDT", new CurrencyDataImpl("BDT", "Tk", 2, "Tk"));
    // franco belga (convertible)
    result.put("BEC", new CurrencyDataImpl("BEC", "BEC", 2));
    // franco belga
    result.put("BEF", new CurrencyDataImpl("BEF", "BF", 130));
    // franco belga (financiero)
    result.put("BEL", new CurrencyDataImpl("BEL", "BEL", 2));
    // lev fuerte búlgaro
    result.put("BGL", new CurrencyDataImpl("BGL", "BGL", 130));
    // nuevo lev búlgaro
    result.put("BGN", new CurrencyDataImpl("BGN", "BGN", 2));
    // dinar bahreiní
    result.put("BHD", new CurrencyDataImpl("BHD", "BD", 3));
    // franco de Burundi
    result.put("BIF", new CurrencyDataImpl("BIF", "FBu", 0));
    // dólar de Bermudas
    result.put("BMD", new CurrencyDataImpl("BMD", "BD$", 2));
    // dólar de Brunéi
    result.put("BND", new CurrencyDataImpl("BND", "BN$", 2));
    // boliviano
    result.put("BOB", new CurrencyDataImpl("BOB", "Bs", 2));
    // peso boliviano
    result.put("BOP", new CurrencyDataImpl("BOP", "$b.", 130));
    // MVDOL boliviano
    result.put("BOV", new CurrencyDataImpl("BOV", "BOV", 2));
    // nuevo cruceiro brasileño (1967-1986)
    result.put("BRB", new CurrencyDataImpl("BRB", "BRB", 130));
    // cruzado brasileño
    result.put("BRC", new CurrencyDataImpl("BRC", "BRC", 130));
    // cruceiro brasileño (1990-1993)
    result.put("BRE", new CurrencyDataImpl("BRE", "BRE", 130));
    // real brasileño
    result.put("BRL", new CurrencyDataImpl("BRL", "R$", 2, "R$"));
    // nuevo cruzado brasileño
    result.put("BRN", new CurrencyDataImpl("BRN", "BRN", 130));
    // cruceiro brasileño
    result.put("BRR", new CurrencyDataImpl("BRR", "BRR", 130));
    // dólar de las Bahamas
    result.put("BSD", new CurrencyDataImpl("BSD", "BS$", 2));
    // ngultrum butanés
    result.put("BTN", new CurrencyDataImpl("BTN", "Nu.", 2));
    // kyat birmano
    result.put("BUK", new CurrencyDataImpl("BUK", "BUK", 130));
    // pula botsuano
    result.put("BWP", new CurrencyDataImpl("BWP", "BWP", 2));
    // nuevo rublo bielorruso (1994-1999)
    result.put("BYB", new CurrencyDataImpl("BYB", "BYB", 130));
    // rublo bielorruso
    result.put("BYR", new CurrencyDataImpl("BYR", "BYR", 0));
    // dólar de Belice
    result.put("BZD", new CurrencyDataImpl("BZD", "BZ$", 2));
    // dólar canadiense
    result.put("CAD", new CurrencyDataImpl("CAD", "CA$", 2, "C$"));
    // franco congoleño
    result.put("CDF", new CurrencyDataImpl("CDF", "CDF", 2));
    // euro WIR
    result.put("CHE", new CurrencyDataImpl("CHE", "CHE", 2));
    // franco suizo
    result.put("CHF", new CurrencyDataImpl("CHF", "Fr.", 2, "CHF"));
    // franco WIR
    result.put("CHW", new CurrencyDataImpl("CHW", "CHW", 2));
    // CLE
    result.put("CLE", new CurrencyDataImpl("CLE", "Eº", 130));
    // unidad de fomento chilena
    result.put("CLF", new CurrencyDataImpl("CLF", "CLF", 0));
    // peso chileno
    result.put("CLP", new CurrencyDataImpl("CLP", "$", 0, "CL$"));
    // yuan renminbi chino
    result.put("CNY", new CurrencyDataImpl("CNY", "CN¥", 2, "RMB¥"));
    // peso colombiano
    result.put("COP", new CurrencyDataImpl("COP", "CO$", 0, "COL$"));
    // unidad de valor real colombiana
    result.put("COU", new CurrencyDataImpl("COU", "COU", 2));
    // colón costarricense
    result.put("CRC", new CurrencyDataImpl("CRC", "₡", 0, "CR₡"));
    // antiguo dinar serbio
    result.put("CSD", new CurrencyDataImpl("CSD", "CSD", 130));
    // corona fuerte checoslovaca
    result.put("CSK", new CurrencyDataImpl("CSK", "CSK", 130));
    // CUC
    result.put("CUC", new CurrencyDataImpl("CUC", "CUC$", 2));
    // peso cubano
    result.put("CUP", new CurrencyDataImpl("CUP", "CU$", 2, "$MN"));
    // escudo de Cabo Verde
    result.put("CVE", new CurrencyDataImpl("CVE", "CV$", 2));
    // libra chipriota
    result.put("CYP", new CurrencyDataImpl("CYP", "CY£", 130));
    // corona checa
    result.put("CZK", new CurrencyDataImpl("CZK", "Kč", 2, "Kč"));
    // ostmark de Alemania del Este
    result.put("DDM", new CurrencyDataImpl("DDM", "DDM", 130));
    // marco alemán
    result.put("DEM", new CurrencyDataImpl("DEM", "DM", 130));
    // franco de Yibuti
    result.put("DJF", new CurrencyDataImpl("DJF", "Fdj", 0));
    // corona danesa
    result.put("DKK", new CurrencyDataImpl("DKK", "Dkr", 2, "kr"));
    // peso dominicano
    result.put("DOP", new CurrencyDataImpl("DOP", "RD$", 2, "RD$"));
    // dinar argelino
    result.put("DZD", new CurrencyDataImpl("DZD", "DA", 2));
    // sucre ecuatoriano
    result.put("ECS", new CurrencyDataImpl("ECS", "ECS", 130));
    // unidad de valor constante (UVC) ecuatoriana
    result.put("ECV", new CurrencyDataImpl("ECV", "ECV", 2));
    // corona estonia
    result.put("EEK", new CurrencyDataImpl("EEK", "Ekr", 2));
    // libra egipcia
    result.put("EGP", new CurrencyDataImpl("EGP", "EG£", 2, "LE"));
    // EQE
    result.put("EQE", new CurrencyDataImpl("EQE", "EQE", 130));
    // nakfa eritreo
    result.put("ERN", new CurrencyDataImpl("ERN", "Nfk", 2));
    // peseta española (cuenta A)
    result.put("ESA", new CurrencyDataImpl("ESA", "ESA", 2));
    // peseta española (cuenta convertible)
    result.put("ESB", new CurrencyDataImpl("ESB", "ESB", 2));
    // peseta española
    result.put("ESP", new CurrencyDataImpl("ESP", "₧", 128));
    // birr etíope
    result.put("ETB", new CurrencyDataImpl("ETB", "Br", 2));
    // euro
    result.put("EUR", new CurrencyDataImpl("EUR", "€", 2, "€"));
    // marco finlandés
    result.put("FIM", new CurrencyDataImpl("FIM", "mk", 130));
    // dólar de las Islas Fiyi
    result.put("FJD", new CurrencyDataImpl("FJD", "FJ$", 2));
    // libra de las Islas Malvinas
    result.put("FKP", new CurrencyDataImpl("FKP", "FK£", 2));
    // franco francés
    result.put("FRF", new CurrencyDataImpl("FRF", "₣", 130));
    // libra esterlina británica
    result.put("GBP", new CurrencyDataImpl("GBP", "£", 2, "GB£"));
    // kupon larit georgiano
    result.put("GEK", new CurrencyDataImpl("GEK", "GEK", 130));
    // lari georgiano
    result.put("GEL", new CurrencyDataImpl("GEL", "GEL", 2));
    // cedi ghanés
    result.put("GHC", new CurrencyDataImpl("GHC", "₵", 130));
    // GHS
    result.put("GHS", new CurrencyDataImpl("GHS", "GH₵", 2));
    // libra de Gibraltar
    result.put("GIP", new CurrencyDataImpl("GIP", "GI£", 2));
    // dalasi gambiano
    result.put("GMD", new CurrencyDataImpl("GMD", "GMD", 2));
    // franco guineano
    result.put("GNF", new CurrencyDataImpl("GNF", "FG", 0));
    // syli guineano
    result.put("GNS", new CurrencyDataImpl("GNS", "GNS", 130));
    // ekuele de Guinea Ecuatorial
    result.put("GQE", new CurrencyDataImpl("GQE", "GQE", 130));
    // dracma griego
    result.put("GRD", new CurrencyDataImpl("GRD", "₯", 130));
    // quetzal guatemalteco
    result.put("GTQ", new CurrencyDataImpl("GTQ", "GTQ", 2));
    // escudo de Guinea Portuguesa
    result.put("GWE", new CurrencyDataImpl("GWE", "GWE", 130));
    // peso de Guinea-Bissáu
    result.put("GWP", new CurrencyDataImpl("GWP", "GWP", 2));
    // dólar guyanés
    result.put("GYD", new CurrencyDataImpl("GYD", "GY$", 0));
    // dólar de Hong Kong
    result.put("HKD", new CurrencyDataImpl("HKD", "HK$", 2, "HK$"));
    // lempira hondureño
    result.put("HNL", new CurrencyDataImpl("HNL", "HNL", 2));
    // dinar croata
    result.put("HRD", new CurrencyDataImpl("HRD", "HRD", 130));
    // kuna croata
    result.put("HRK", new CurrencyDataImpl("HRK", "kn", 2));
    // gourde haitiano
    result.put("HTG", new CurrencyDataImpl("HTG", "HTG", 2));
    // florín húngaro
    result.put("HUF", new CurrencyDataImpl("HUF", "Ft", 0));
    // rupia indonesia
    result.put("IDR", new CurrencyDataImpl("IDR", "Rp", 0));
    // libra irlandesa
    result.put("IEP", new CurrencyDataImpl("IEP", "IR£", 130));
    // libra israelí
    result.put("ILP", new CurrencyDataImpl("ILP", "I£", 130));
    // nuevo sheqel israelí
    result.put("ILS", new CurrencyDataImpl("ILS", "₪", 2, "IL₪"));
    // rupia india
    result.put("INR", new CurrencyDataImpl("INR", "Rs", 2, "Rs"));
    // dinar iraquí
    result.put("IQD", new CurrencyDataImpl("IQD", "IQD", 0));
    // rial iraní
    result.put("IRR", new CurrencyDataImpl("IRR", "IRR", 0));
    // corona islandesa
    result.put("ISK", new CurrencyDataImpl("ISK", "Ikr", 0, "kr"));
    // lira italiana
    result.put("ITL", new CurrencyDataImpl("ITL", "IT₤", 128));
    // dólar de Jamaica
    result.put("JMD", new CurrencyDataImpl("JMD", "J$", 2, "JA$"));
    // dinar jordano
    result.put("JOD", new CurrencyDataImpl("JOD", "JD", 3));
    // yen japonés
    result.put("JPY", new CurrencyDataImpl("JPY", "JP¥", 0, "JP¥"));
    // chelín keniata
    result.put("KES", new CurrencyDataImpl("KES", "Ksh", 2));
    // som kirguís
    result.put("KGS", new CurrencyDataImpl("KGS", "KGS", 2));
    // riel camboyano
    result.put("KHR", new CurrencyDataImpl("KHR", "KHR", 2));
    // franco comorense
    result.put("KMF", new CurrencyDataImpl("KMF", "CF", 0));
    // won norcoreano
    result.put("KPW", new CurrencyDataImpl("KPW", "KPW", 0));
    // won surcoreano
    result.put("KRW", new CurrencyDataImpl("KRW", "₩", 0, "KR₩"));
    // dinar kuwaití
    result.put("KWD", new CurrencyDataImpl("KWD", "KD", 3));
    // dólar de las Islas Caimán
    result.put("KYD", new CurrencyDataImpl("KYD", "KY$", 2));
    // tenge kazako
    result.put("KZT", new CurrencyDataImpl("KZT", "KZT", 2));
    // kip laosiano
    result.put("LAK", new CurrencyDataImpl("LAK", "₭", 0));
    // libra libanesa
    result.put("LBP", new CurrencyDataImpl("LBP", "LB£", 0));
    // rupia de Sri Lanka
    result.put("LKR", new CurrencyDataImpl("LKR", "SLRs", 2, "SLRs"));
    // dólar liberiano
    result.put("LRD", new CurrencyDataImpl("LRD", "L$", 2));
    // loti lesothense
    result.put("LSL", new CurrencyDataImpl("LSL", "LSL", 2));
    // LSM
    result.put("LSM", new CurrencyDataImpl("LSM", "LSM", 130));
    // litas lituano
    result.put("LTL", new CurrencyDataImpl("LTL", "Lt", 2));
    // talonas lituano
    result.put("LTT", new CurrencyDataImpl("LTT", "LTT", 130));
    // franco convertible luxemburgués
    result.put("LUC", new CurrencyDataImpl("LUC", "LUC", 2));
    // franco luxemburgués
    result.put("LUF", new CurrencyDataImpl("LUF", "LUF", 128));
    // franco financiero luxemburgués
    result.put("LUL", new CurrencyDataImpl("LUL", "LUL", 2));
    // lats letón
    result.put("LVL", new CurrencyDataImpl("LVL", "Ls", 2));
    // rublo letón
    result.put("LVR", new CurrencyDataImpl("LVR", "LVR", 130));
    // dinar libio
    result.put("LYD", new CurrencyDataImpl("LYD", "LD", 3));
    // dirham marroquí
    result.put("MAD", new CurrencyDataImpl("MAD", "MAD", 2));
    // franco marroquí
    result.put("MAF", new CurrencyDataImpl("MAF", "MAF", 130));
    // leu moldavo
    result.put("MDL", new CurrencyDataImpl("MDL", "MDL", 2));
    // ariary malgache
    result.put("MGA", new CurrencyDataImpl("MGA", "MGA", 0));
    // franco malgache
    result.put("MGF", new CurrencyDataImpl("MGF", "MGF", 128));
    // dinar macedonio
    result.put("MKD", new CurrencyDataImpl("MKD", "MKD", 2));
    // franco malí
    result.put("MLF", new CurrencyDataImpl("MLF", "MLF", 130));
    // kyat de Myanmar
    result.put("MMK", new CurrencyDataImpl("MMK", "MMK", 0));
    // tugrik mongol
    result.put("MNT", new CurrencyDataImpl("MNT", "₮", 0, "MN₮"));
    // pataca de Macao
    result.put("MOP", new CurrencyDataImpl("MOP", "MOP$", 2));
    // ouguiya mauritano
    result.put("MRO", new CurrencyDataImpl("MRO", "UM", 0));
    // lira maltesa
    result.put("MTL", new CurrencyDataImpl("MTL", "Lm", 130));
    // libra maltesa
    result.put("MTP", new CurrencyDataImpl("MTP", "MT£", 130));
    // rupia mauriciana
    result.put("MUR", new CurrencyDataImpl("MUR", "MURs", 0));
    // rufiyaa de Maldivas
    result.put("MVR", new CurrencyDataImpl("MVR", "MVR", 2));
    // kwacha de Malawi
    result.put("MWK", new CurrencyDataImpl("MWK", "MWK", 2));
    // peso mexicano
    result.put("MXN", new CurrencyDataImpl("MXN", "Mex$", 2, "Mex$"));
    // peso de plata mexicano (1861-1992)
    result.put("MXP", new CurrencyDataImpl("MXP", "MX$", 130));
    // unidad de inversión (UDI) mexicana
    result.put("MXV", new CurrencyDataImpl("MXV", "MXV", 2));
    // ringgit malasio
    result.put("MYR", new CurrencyDataImpl("MYR", "RM", 2, "RM"));
    // escudo mozambiqueño
    result.put("MZE", new CurrencyDataImpl("MZE", "MZE", 130));
    // antiguo metical mozambiqueño
    result.put("MZM", new CurrencyDataImpl("MZM", "Mt", 130));
    // metical mozambiqueño
    result.put("MZN", new CurrencyDataImpl("MZN", "MTn", 2));
    // dólar de Namibia
    result.put("NAD", new CurrencyDataImpl("NAD", "N$", 2));
    // naira nigeriano
    result.put("NGN", new CurrencyDataImpl("NGN", "₦", 2));
    // córdoba nicaragüense
    result.put("NIC", new CurrencyDataImpl("NIC", "NIC", 130));
    // córdoba oro nicaragüense
    result.put("NIO", new CurrencyDataImpl("NIO", "C$", 2));
    // florín neerlandés
    result.put("NLG", new CurrencyDataImpl("NLG", "fl", 130));
    // corona noruega
    result.put("NOK", new CurrencyDataImpl("NOK", "Nkr", 2, "NOkr"));
    // rupia nepalesa
    result.put("NPR", new CurrencyDataImpl("NPR", "NPRs", 2));
    // dólar neozelandés
    result.put("NZD", new CurrencyDataImpl("NZD", "NZ$", 2));
    // rial omaní
    result.put("OMR", new CurrencyDataImpl("OMR", "OMR", 3));
    // balboa panameño
    result.put("PAB", new CurrencyDataImpl("PAB", "B/.", 2, "B/."));
    // inti peruano
    result.put("PEI", new CurrencyDataImpl("PEI", "I/.", 130));
    // nuevo sol peruano
    result.put("PEN", new CurrencyDataImpl("PEN", "S/.", 2, "S/."));
    // sol peruano
    result.put("PES", new CurrencyDataImpl("PES", "PES", 130));
    // kina de Papúa Nueva Guinea
    result.put("PGK", new CurrencyDataImpl("PGK", "PGK", 2));
    // peso filipino
    result.put("PHP", new CurrencyDataImpl("PHP", "₱", 2, "PHP"));
    // rupia pakistaní
    result.put("PKR", new CurrencyDataImpl("PKR", "PKRs", 0, "PKRs."));
    // zloty polaco
    result.put("PLN", new CurrencyDataImpl("PLN", "zł", 2));
    // zloty polaco (1950-1995)
    result.put("PLZ", new CurrencyDataImpl("PLZ", "PLZ", 130));
    // escudo portugués
    result.put("PTE", new CurrencyDataImpl("PTE", "Esc", 130));
    // guaraní paraguayo
    result.put("PYG", new CurrencyDataImpl("PYG", "₲", 0));
    // riyal de Qatar
    result.put("QAR", new CurrencyDataImpl("QAR", "QR", 2));
    // dólar rodesiano
    result.put("RHD", new CurrencyDataImpl("RHD", "RH$", 130));
    // antiguo leu rumano
    result.put("ROL", new CurrencyDataImpl("ROL", "ROL", 130));
    // leu rumano
    result.put("RON", new CurrencyDataImpl("RON", "RON", 2));
    // dinar serbio
    result.put("RSD", new CurrencyDataImpl("RSD", "din.", 0));
    // rublo ruso
    result.put("RUB", new CurrencyDataImpl("RUB", "руб", 2, "руб"));
    // rublo ruso (1991-1998)
    result.put("RUR", new CurrencyDataImpl("RUR", "RUR", 130));
    // franco ruandés
    result.put("RWF", new CurrencyDataImpl("RWF", "RWF", 0));
    // riyal saudí
    result.put("SAR", new CurrencyDataImpl("SAR", "SR", 2, "SR"));
    // dólar de las Islas Salomón
    result.put("SBD", new CurrencyDataImpl("SBD", "SI$", 2));
    // rupia de Seychelles
    result.put("SCR", new CurrencyDataImpl("SCR", "SRe", 2));
    // dinar sudanés
    result.put("SDD", new CurrencyDataImpl("SDD", "LSd", 130));
    // libra sudanesa
    result.put("SDG", new CurrencyDataImpl("SDG", "SDG", 2));
    // libra sudanesa antigua
    result.put("SDP", new CurrencyDataImpl("SDP", "SDP", 130));
    // corona sueca
    result.put("SEK", new CurrencyDataImpl("SEK", "Skr", 2, "kr"));
    // dólar singapurense
    result.put("SGD", new CurrencyDataImpl("SGD", "S$", 2, "S$"));
    // libra de Santa Elena
    result.put("SHP", new CurrencyDataImpl("SHP", "SH£", 2));
    // tólar esloveno
    result.put("SIT", new CurrencyDataImpl("SIT", "SIT", 130));
    // corona eslovaca
    result.put("SKK", new CurrencyDataImpl("SKK", "Sk", 130));
    // leone de Sierra Leona
    result.put("SLL", new CurrencyDataImpl("SLL", "Le", 0));
    // chelín somalí
    result.put("SOS", new CurrencyDataImpl("SOS", "Ssh", 0));
    // dólar surinamés
    result.put("SRD", new CurrencyDataImpl("SRD", "SR$", 2));
    // florín surinamés
    result.put("SRG", new CurrencyDataImpl("SRG", "Sf", 130));
    // dobra de Santo Tomé y Príncipe
    result.put("STD", new CurrencyDataImpl("STD", "Db", 0));
    // rublo soviético
    result.put("SUR", new CurrencyDataImpl("SUR", "SUR", 130));
    // colón salvadoreño
    result.put("SVC", new CurrencyDataImpl("SVC", "SV₡", 130));
    // libra siria
    result.put("SYP", new CurrencyDataImpl("SYP", "SY£", 0));
    // lilangeni suazi
    result.put("SZL", new CurrencyDataImpl("SZL", "SZL", 2));
    // baht tailandés
    result.put("THB", new CurrencyDataImpl("THB", "฿", 2, "THB"));
    // rublo tayiko
    result.put("TJR", new CurrencyDataImpl("TJR", "TJR", 130));
    // somoni tayiko
    result.put("TJS", new CurrencyDataImpl("TJS", "TJS", 2));
    // manat turcomano
    result.put("TMM", new CurrencyDataImpl("TMM", "TMM", 128));
    // dinar tunecino
    result.put("TND", new CurrencyDataImpl("TND", "DT", 3));
    // paʻanga tongano
    result.put("TOP", new CurrencyDataImpl("TOP", "T$", 2));
    // escudo timorense
    result.put("TPE", new CurrencyDataImpl("TPE", "TPE", 130));
    // lira turca antigua
    result.put("TRL", new CurrencyDataImpl("TRL", "TRL", 128));
    // nueva lira turca
    result.put("TRY", new CurrencyDataImpl("TRY", "TL", 2, "YTL"));
    // dólar de Trinidad y Tobago
    result.put("TTD", new CurrencyDataImpl("TTD", "TT$", 2));
    // nuevo dólar taiwanés
    result.put("TWD", new CurrencyDataImpl("TWD", "NT$", 2, "NT$"));
    // chelín tanzano
    result.put("TZS", new CurrencyDataImpl("TZS", "TSh", 0));
    // grivna ucraniana
    result.put("UAH", new CurrencyDataImpl("UAH", "₴", 2));
    // karbovanet ucraniano
    result.put("UAK", new CurrencyDataImpl("UAK", "UAK", 130));
    // chelín ugandés (1966-1987)
    result.put("UGS", new CurrencyDataImpl("UGS", "UGS", 130));
    // chelín ugandés
    result.put("UGX", new CurrencyDataImpl("UGX", "USh", 0));
    // dólar estadounidense
    result.put("USD", new CurrencyDataImpl("USD", "US$", 2, "US$"));
    // dólar estadounidense (día siguiente)
    result.put("USN", new CurrencyDataImpl("USN", "USN", 2));
    // dólar estadounidense (mismo día)
    result.put("USS", new CurrencyDataImpl("USS", "USS", 2));
    // peso uruguayo en unidades indexadas
    result.put("UYI", new CurrencyDataImpl("UYI", "UYI", 2));
    // peso uruguayo (1975-1993)
    result.put("UYP", new CurrencyDataImpl("UYP", "UYP", 130));
    // peso uruguayo
    result.put("UYU", new CurrencyDataImpl("UYU", "$U", 2, "UY$"));
    // sum uzbeko
    result.put("UZS", new CurrencyDataImpl("UZS", "UZS", 0));
    // bolívar venezolano
    result.put("VEB", new CurrencyDataImpl("VEB", "VEB", 130));
    // bolívar fuerte venezolano
    result.put("VEF", new CurrencyDataImpl("VEF", "Bs.F.", 2));
    // dong vietnamita
    result.put("VND", new CurrencyDataImpl("VND", "₫", 24, "₫"));
    // vatu vanuatuense
    result.put("VUV", new CurrencyDataImpl("VUV", "VT", 0));
    // tala samoano
    result.put("WST", new CurrencyDataImpl("WST", "WS$", 2));
    // franco CFA BEAC
    result.put("XAF", new CurrencyDataImpl("XAF", "FCFA", 0));
    // plata
    result.put("XAG", new CurrencyDataImpl("XAG", "XAG", 2));
    // oro
    result.put("XAU", new CurrencyDataImpl("XAU", "XAU", 2));
    // unidad compuesta europea
    result.put("XBA", new CurrencyDataImpl("XBA", "XBA", 2));
    // unidad monetaria europea
    result.put("XBB", new CurrencyDataImpl("XBB", "XBB", 2));
    // unidad de cuenta europea (XBC)
    result.put("XBC", new CurrencyDataImpl("XBC", "XBC", 2));
    // unidad de cuenta europea (XBD)
    result.put("XBD", new CurrencyDataImpl("XBD", "XBD", 2));
    // dólar del Caribe Oriental
    result.put("XCD", new CurrencyDataImpl("XCD", "EC$", 2));
    // derechos especiales de giro
    result.put("XDR", new CurrencyDataImpl("XDR", "XDR", 2));
    // unidad de moneda europea
    result.put("XEU", new CurrencyDataImpl("XEU", "XEU", 2));
    // franco oro francés
    result.put("XFO", new CurrencyDataImpl("XFO", "XFO", 2));
    // franco UIC francés
    result.put("XFU", new CurrencyDataImpl("XFU", "XFU", 2));
    // franco CFA BCEAO
    result.put("XOF", new CurrencyDataImpl("XOF", "CFA", 0));
    // paladio
    result.put("XPD", new CurrencyDataImpl("XPD", "XPD", 2));
    // franco CFP
    result.put("XPF", new CurrencyDataImpl("XPF", "CFPF", 0));
    // platino
    result.put("XPT", new CurrencyDataImpl("XPT", "XPT", 2));
    // fondos RINET
    result.put("XRE", new CurrencyDataImpl("XRE", "XRE", 2));
    // código reservado para pruebas
    result.put("XTS", new CurrencyDataImpl("XTS", "XTS", 2));
    // Sin divisa
    result.put("XXX", new CurrencyDataImpl("XXX", "XXX", 2));
    // dinar yemení
    result.put("YDD", new CurrencyDataImpl("YDD", "YDD", 130));
    // rial yemení
    result.put("YER", new CurrencyDataImpl("YER", "YR", 0, "YER"));
    // dinar fuerte yugoslavo
    result.put("YUD", new CurrencyDataImpl("YUD", "YUD", 130));
    // super dinar yugoslavo
    result.put("YUM", new CurrencyDataImpl("YUM", "YUM", 130));
    // dinar convertible yugoslavo
    result.put("YUN", new CurrencyDataImpl("YUN", "YUN", 130));
    // rand sudafricano (financiero)
    result.put("ZAL", new CurrencyDataImpl("ZAL", "ZAL", 2));
    // rand sudafricano
    result.put("ZAR", new CurrencyDataImpl("ZAR", "R", 2, "ZAR"));
    // kwacha zambiano
    result.put("ZMK", new CurrencyDataImpl("ZMK", "ZK", 0));
    // nuevo zaire zaireño
    result.put("ZRN", new CurrencyDataImpl("ZRN", "NZ", 130));
    // zaire zaireño
    result.put("ZRZ", new CurrencyDataImpl("ZRZ", "ZRZ", 130));
    // dólar de Zimbabue
    result.put("ZWD", new CurrencyDataImpl("ZWD", "Z$", 128));
    return result;
  }
  
  @Override
  protected JavaScriptObject loadCurrencyMapNative() {
    return overrideMap(super.loadCurrencyMapNative(), loadMyCurrencyMapOverridesNative());
  }
  
  private native JavaScriptObject loadMyCurrencyMapOverridesNative() /*-{
    return {
      // peseta andorrana
      "ADP": [ "ADP", "ADP", 128],
      // dírham de los Emiratos Árabes Unidos
      "AED": [ "AED", "DH", 2, "DH"],
      // afgani (1927-2002)
      "AFA": [ "AFA", "AFA", 130],
      // afgani
      "AFN": [ "AFN", "Af", 0],
      // lek albanés
      "ALL": [ "ALL", "ALL", 0],
      // dram armenio
      "AMD": [ "AMD", "AMD", 0],
      // florín de las Antillas Neerlandesas
      "ANG": [ "ANG", "NAf.", 2],
      // kwanza angoleño
      "AOA": [ "AOA", "Kz", 2],
      // kwanza angoleño (1977-1990)
      "AOK": [ "AOK", "AOK", 130],
      // nuevo kwanza angoleño (1990-2000)
      "AON": [ "AON", "AON", 130],
      // kwanza reajustado angoleño (1995-1999)
      "AOR": [ "AOR", "AOR", 130],
      // austral argentino
      "ARA": [ "ARA", "₳", 130],
      // ARL
      "ARL": [ "ARL", "$L", 130],
      // ARM
      "ARM": [ "ARM", "m$n", 130],
      // peso argentino (1983-1985)
      "ARP": [ "ARP", "ARP", 130],
      // peso argentino
      "ARS": [ "ARS", "AR$", 2, "AR$"],
      // chelín austriaco
      "ATS": [ "ATS", "ATS", 130],
      // dólar australiano
      "AUD": [ "AUD", "AU$", 2, "AU$"],
      // florín de Aruba
      "AWG": [ "AWG", "Afl.", 2],
      // manat azerí (1993-2006)
      "AZM": [ "AZM", "AZM", 130],
      // manat azerí
      "AZN": [ "AZN", "man.", 2],
      // dinar bosnio
      "BAD": [ "BAD", "BAD", 130],
      // marco convertible de Bosnia-Herzegovina
      "BAM": [ "BAM", "KM", 2],
      // dólar de Barbados
      "BBD": [ "BBD", "Bds$", 2],
      // taka de Bangladesh
      "BDT": [ "BDT", "Tk", 2, "Tk"],
      // franco belga (convertible)
      "BEC": [ "BEC", "BEC", 2],
      // franco belga
      "BEF": [ "BEF", "BF", 130],
      // franco belga (financiero)
      "BEL": [ "BEL", "BEL", 2],
      // lev fuerte búlgaro
      "BGL": [ "BGL", "BGL", 130],
      // nuevo lev búlgaro
      "BGN": [ "BGN", "BGN", 2],
      // dinar bahreiní
      "BHD": [ "BHD", "BD", 3],
      // franco de Burundi
      "BIF": [ "BIF", "FBu", 0],
      // dólar de Bermudas
      "BMD": [ "BMD", "BD$", 2],
      // dólar de Brunéi
      "BND": [ "BND", "BN$", 2],
      // boliviano
      "BOB": [ "BOB", "Bs", 2],
      // peso boliviano
      "BOP": [ "BOP", "$b.", 130],
      // MVDOL boliviano
      "BOV": [ "BOV", "BOV", 2],
      // nuevo cruceiro brasileño (1967-1986)
      "BRB": [ "BRB", "BRB", 130],
      // cruzado brasileño
      "BRC": [ "BRC", "BRC", 130],
      // cruceiro brasileño (1990-1993)
      "BRE": [ "BRE", "BRE", 130],
      // real brasileño
      "BRL": [ "BRL", "R$", 2, "R$"],
      // nuevo cruzado brasileño
      "BRN": [ "BRN", "BRN", 130],
      // cruceiro brasileño
      "BRR": [ "BRR", "BRR", 130],
      // dólar de las Bahamas
      "BSD": [ "BSD", "BS$", 2],
      // ngultrum butanés
      "BTN": [ "BTN", "Nu.", 2],
      // kyat birmano
      "BUK": [ "BUK", "BUK", 130],
      // pula botsuano
      "BWP": [ "BWP", "BWP", 2],
      // nuevo rublo bielorruso (1994-1999)
      "BYB": [ "BYB", "BYB", 130],
      // rublo bielorruso
      "BYR": [ "BYR", "BYR", 0],
      // dólar de Belice
      "BZD": [ "BZD", "BZ$", 2],
      // dólar canadiense
      "CAD": [ "CAD", "CA$", 2, "C$"],
      // franco congoleño
      "CDF": [ "CDF", "CDF", 2],
      // euro WIR
      "CHE": [ "CHE", "CHE", 2],
      // franco suizo
      "CHF": [ "CHF", "Fr.", 2, "CHF"],
      // franco WIR
      "CHW": [ "CHW", "CHW", 2],
      // CLE
      "CLE": [ "CLE", "Eº", 130],
      // unidad de fomento chilena
      "CLF": [ "CLF", "CLF", 0],
      // peso chileno
      "CLP": [ "CLP", "$", 0, "CL$"],
      // yuan renminbi chino
      "CNY": [ "CNY", "CN¥", 2, "RMB¥"],
      // peso colombiano
      "COP": [ "COP", "CO$", 0, "COL$"],
      // unidad de valor real colombiana
      "COU": [ "COU", "COU", 2],
      // colón costarricense
      "CRC": [ "CRC", "₡", 0, "CR₡"],
      // antiguo dinar serbio
      "CSD": [ "CSD", "CSD", 130],
      // corona fuerte checoslovaca
      "CSK": [ "CSK", "CSK", 130],
      // CUC
      "CUC": [ "CUC", "CUC$", 2],
      // peso cubano
      "CUP": [ "CUP", "CU$", 2, "$MN"],
      // escudo de Cabo Verde
      "CVE": [ "CVE", "CV$", 2],
      // libra chipriota
      "CYP": [ "CYP", "CY£", 130],
      // corona checa
      "CZK": [ "CZK", "Kč", 2, "Kč"],
      // ostmark de Alemania del Este
      "DDM": [ "DDM", "DDM", 130],
      // marco alemán
      "DEM": [ "DEM", "DM", 130],
      // franco de Yibuti
      "DJF": [ "DJF", "Fdj", 0],
      // corona danesa
      "DKK": [ "DKK", "Dkr", 2, "kr"],
      // peso dominicano
      "DOP": [ "DOP", "RD$", 2, "RD$"],
      // dinar argelino
      "DZD": [ "DZD", "DA", 2],
      // sucre ecuatoriano
      "ECS": [ "ECS", "ECS", 130],
      // unidad de valor constante (UVC) ecuatoriana
      "ECV": [ "ECV", "ECV", 2],
      // corona estonia
      "EEK": [ "EEK", "Ekr", 2],
      // libra egipcia
      "EGP": [ "EGP", "EG£", 2, "LE"],
      // EQE
      "EQE": [ "EQE", "EQE", 130],
      // nakfa eritreo
      "ERN": [ "ERN", "Nfk", 2],
      // peseta española (cuenta A)
      "ESA": [ "ESA", "ESA", 2],
      // peseta española (cuenta convertible)
      "ESB": [ "ESB", "ESB", 2],
      // peseta española
      "ESP": [ "ESP", "₧", 128],
      // birr etíope
      "ETB": [ "ETB", "Br", 2],
      // euro
      "EUR": [ "EUR", "€", 2, "€"],
      // marco finlandés
      "FIM": [ "FIM", "mk", 130],
      // dólar de las Islas Fiyi
      "FJD": [ "FJD", "FJ$", 2],
      // libra de las Islas Malvinas
      "FKP": [ "FKP", "FK£", 2],
      // franco francés
      "FRF": [ "FRF", "₣", 130],
      // libra esterlina británica
      "GBP": [ "GBP", "£", 2, "GB£"],
      // kupon larit georgiano
      "GEK": [ "GEK", "GEK", 130],
      // lari georgiano
      "GEL": [ "GEL", "GEL", 2],
      // cedi ghanés
      "GHC": [ "GHC", "₵", 130],
      // GHS
      "GHS": [ "GHS", "GH₵", 2],
      // libra de Gibraltar
      "GIP": [ "GIP", "GI£", 2],
      // dalasi gambiano
      "GMD": [ "GMD", "GMD", 2],
      // franco guineano
      "GNF": [ "GNF", "FG", 0],
      // syli guineano
      "GNS": [ "GNS", "GNS", 130],
      // ekuele de Guinea Ecuatorial
      "GQE": [ "GQE", "GQE", 130],
      // dracma griego
      "GRD": [ "GRD", "₯", 130],
      // quetzal guatemalteco
      "GTQ": [ "GTQ", "GTQ", 2],
      // escudo de Guinea Portuguesa
      "GWE": [ "GWE", "GWE", 130],
      // peso de Guinea-Bissáu
      "GWP": [ "GWP", "GWP", 2],
      // dólar guyanés
      "GYD": [ "GYD", "GY$", 0],
      // dólar de Hong Kong
      "HKD": [ "HKD", "HK$", 2, "HK$"],
      // lempira hondureño
      "HNL": [ "HNL", "HNL", 2],
      // dinar croata
      "HRD": [ "HRD", "HRD", 130],
      // kuna croata
      "HRK": [ "HRK", "kn", 2],
      // gourde haitiano
      "HTG": [ "HTG", "HTG", 2],
      // florín húngaro
      "HUF": [ "HUF", "Ft", 0],
      // rupia indonesia
      "IDR": [ "IDR", "Rp", 0],
      // libra irlandesa
      "IEP": [ "IEP", "IR£", 130],
      // libra israelí
      "ILP": [ "ILP", "I£", 130],
      // nuevo sheqel israelí
      "ILS": [ "ILS", "₪", 2, "IL₪"],
      // rupia india
      "INR": [ "INR", "Rs", 2, "Rs"],
      // dinar iraquí
      "IQD": [ "IQD", "IQD", 0],
      // rial iraní
      "IRR": [ "IRR", "IRR", 0],
      // corona islandesa
      "ISK": [ "ISK", "Ikr", 0, "kr"],
      // lira italiana
      "ITL": [ "ITL", "IT₤", 128],
      // dólar de Jamaica
      "JMD": [ "JMD", "J$", 2, "JA$"],
      // dinar jordano
      "JOD": [ "JOD", "JD", 3],
      // yen japonés
      "JPY": [ "JPY", "JP¥", 0, "JP¥"],
      // chelín keniata
      "KES": [ "KES", "Ksh", 2],
      // som kirguís
      "KGS": [ "KGS", "KGS", 2],
      // riel camboyano
      "KHR": [ "KHR", "KHR", 2],
      // franco comorense
      "KMF": [ "KMF", "CF", 0],
      // won norcoreano
      "KPW": [ "KPW", "KPW", 0],
      // won surcoreano
      "KRW": [ "KRW", "₩", 0, "KR₩"],
      // dinar kuwaití
      "KWD": [ "KWD", "KD", 3],
      // dólar de las Islas Caimán
      "KYD": [ "KYD", "KY$", 2],
      // tenge kazako
      "KZT": [ "KZT", "KZT", 2],
      // kip laosiano
      "LAK": [ "LAK", "₭", 0],
      // libra libanesa
      "LBP": [ "LBP", "LB£", 0],
      // rupia de Sri Lanka
      "LKR": [ "LKR", "SLRs", 2, "SLRs"],
      // dólar liberiano
      "LRD": [ "LRD", "L$", 2],
      // loti lesothense
      "LSL": [ "LSL", "LSL", 2],
      // LSM
      "LSM": [ "LSM", "LSM", 130],
      // litas lituano
      "LTL": [ "LTL", "Lt", 2],
      // talonas lituano
      "LTT": [ "LTT", "LTT", 130],
      // franco convertible luxemburgués
      "LUC": [ "LUC", "LUC", 2],
      // franco luxemburgués
      "LUF": [ "LUF", "LUF", 128],
      // franco financiero luxemburgués
      "LUL": [ "LUL", "LUL", 2],
      // lats letón
      "LVL": [ "LVL", "Ls", 2],
      // rublo letón
      "LVR": [ "LVR", "LVR", 130],
      // dinar libio
      "LYD": [ "LYD", "LD", 3],
      // dirham marroquí
      "MAD": [ "MAD", "MAD", 2],
      // franco marroquí
      "MAF": [ "MAF", "MAF", 130],
      // leu moldavo
      "MDL": [ "MDL", "MDL", 2],
      // ariary malgache
      "MGA": [ "MGA", "MGA", 0],
      // franco malgache
      "MGF": [ "MGF", "MGF", 128],
      // dinar macedonio
      "MKD": [ "MKD", "MKD", 2],
      // franco malí
      "MLF": [ "MLF", "MLF", 130],
      // kyat de Myanmar
      "MMK": [ "MMK", "MMK", 0],
      // tugrik mongol
      "MNT": [ "MNT", "₮", 0, "MN₮"],
      // pataca de Macao
      "MOP": [ "MOP", "MOP$", 2],
      // ouguiya mauritano
      "MRO": [ "MRO", "UM", 0],
      // lira maltesa
      "MTL": [ "MTL", "Lm", 130],
      // libra maltesa
      "MTP": [ "MTP", "MT£", 130],
      // rupia mauriciana
      "MUR": [ "MUR", "MURs", 0],
      // rufiyaa de Maldivas
      "MVR": [ "MVR", "MVR", 2],
      // kwacha de Malawi
      "MWK": [ "MWK", "MWK", 2],
      // peso mexicano
      "MXN": [ "MXN", "Mex$", 2, "Mex$"],
      // peso de plata mexicano (1861-1992)
      "MXP": [ "MXP", "MX$", 130],
      // unidad de inversión (UDI) mexicana
      "MXV": [ "MXV", "MXV", 2],
      // ringgit malasio
      "MYR": [ "MYR", "RM", 2, "RM"],
      // escudo mozambiqueño
      "MZE": [ "MZE", "MZE", 130],
      // antiguo metical mozambiqueño
      "MZM": [ "MZM", "Mt", 130],
      // metical mozambiqueño
      "MZN": [ "MZN", "MTn", 2],
      // dólar de Namibia
      "NAD": [ "NAD", "N$", 2],
      // naira nigeriano
      "NGN": [ "NGN", "₦", 2],
      // córdoba nicaragüense
      "NIC": [ "NIC", "NIC", 130],
      // córdoba oro nicaragüense
      "NIO": [ "NIO", "C$", 2],
      // florín neerlandés
      "NLG": [ "NLG", "fl", 130],
      // corona noruega
      "NOK": [ "NOK", "Nkr", 2, "NOkr"],
      // rupia nepalesa
      "NPR": [ "NPR", "NPRs", 2],
      // dólar neozelandés
      "NZD": [ "NZD", "NZ$", 2],
      // rial omaní
      "OMR": [ "OMR", "OMR", 3],
      // balboa panameño
      "PAB": [ "PAB", "B/.", 2, "B/."],
      // inti peruano
      "PEI": [ "PEI", "I/.", 130],
      // nuevo sol peruano
      "PEN": [ "PEN", "S/.", 2, "S/."],
      // sol peruano
      "PES": [ "PES", "PES", 130],
      // kina de Papúa Nueva Guinea
      "PGK": [ "PGK", "PGK", 2],
      // peso filipino
      "PHP": [ "PHP", "₱", 2, "PHP"],
      // rupia pakistaní
      "PKR": [ "PKR", "PKRs", 0, "PKRs."],
      // zloty polaco
      "PLN": [ "PLN", "zł", 2],
      // zloty polaco (1950-1995)
      "PLZ": [ "PLZ", "PLZ", 130],
      // escudo portugués
      "PTE": [ "PTE", "Esc", 130],
      // guaraní paraguayo
      "PYG": [ "PYG", "₲", 0],
      // riyal de Qatar
      "QAR": [ "QAR", "QR", 2],
      // dólar rodesiano
      "RHD": [ "RHD", "RH$", 130],
      // antiguo leu rumano
      "ROL": [ "ROL", "ROL", 130],
      // leu rumano
      "RON": [ "RON", "RON", 2],
      // dinar serbio
      "RSD": [ "RSD", "din.", 0],
      // rublo ruso
      "RUB": [ "RUB", "руб", 2, "руб"],
      // rublo ruso (1991-1998)
      "RUR": [ "RUR", "RUR", 130],
      // franco ruandés
      "RWF": [ "RWF", "RWF", 0],
      // riyal saudí
      "SAR": [ "SAR", "SR", 2, "SR"],
      // dólar de las Islas Salomón
      "SBD": [ "SBD", "SI$", 2],
      // rupia de Seychelles
      "SCR": [ "SCR", "SRe", 2],
      // dinar sudanés
      "SDD": [ "SDD", "LSd", 130],
      // libra sudanesa
      "SDG": [ "SDG", "SDG", 2],
      // libra sudanesa antigua
      "SDP": [ "SDP", "SDP", 130],
      // corona sueca
      "SEK": [ "SEK", "Skr", 2, "kr"],
      // dólar singapurense
      "SGD": [ "SGD", "S$", 2, "S$"],
      // libra de Santa Elena
      "SHP": [ "SHP", "SH£", 2],
      // tólar esloveno
      "SIT": [ "SIT", "SIT", 130],
      // corona eslovaca
      "SKK": [ "SKK", "Sk", 130],
      // leone de Sierra Leona
      "SLL": [ "SLL", "Le", 0],
      // chelín somalí
      "SOS": [ "SOS", "Ssh", 0],
      // dólar surinamés
      "SRD": [ "SRD", "SR$", 2],
      // florín surinamés
      "SRG": [ "SRG", "Sf", 130],
      // dobra de Santo Tomé y Príncipe
      "STD": [ "STD", "Db", 0],
      // rublo soviético
      "SUR": [ "SUR", "SUR", 130],
      // colón salvadoreño
      "SVC": [ "SVC", "SV₡", 130],
      // libra siria
      "SYP": [ "SYP", "SY£", 0],
      // lilangeni suazi
      "SZL": [ "SZL", "SZL", 2],
      // baht tailandés
      "THB": [ "THB", "฿", 2, "THB"],
      // rublo tayiko
      "TJR": [ "TJR", "TJR", 130],
      // somoni tayiko
      "TJS": [ "TJS", "TJS", 2],
      // manat turcomano
      "TMM": [ "TMM", "TMM", 128],
      // dinar tunecino
      "TND": [ "TND", "DT", 3],
      // paʻanga tongano
      "TOP": [ "TOP", "T$", 2],
      // escudo timorense
      "TPE": [ "TPE", "TPE", 130],
      // lira turca antigua
      "TRL": [ "TRL", "TRL", 128],
      // nueva lira turca
      "TRY": [ "TRY", "TL", 2, "YTL"],
      // dólar de Trinidad y Tobago
      "TTD": [ "TTD", "TT$", 2],
      // nuevo dólar taiwanés
      "TWD": [ "TWD", "NT$", 2, "NT$"],
      // chelín tanzano
      "TZS": [ "TZS", "TSh", 0],
      // grivna ucraniana
      "UAH": [ "UAH", "₴", 2],
      // karbovanet ucraniano
      "UAK": [ "UAK", "UAK", 130],
      // chelín ugandés (1966-1987)
      "UGS": [ "UGS", "UGS", 130],
      // chelín ugandés
      "UGX": [ "UGX", "USh", 0],
      // dólar estadounidense
      "USD": [ "USD", "US$", 2, "US$"],
      // dólar estadounidense (día siguiente)
      "USN": [ "USN", "USN", 2],
      // dólar estadounidense (mismo día)
      "USS": [ "USS", "USS", 2],
      // peso uruguayo en unidades indexadas
      "UYI": [ "UYI", "UYI", 2],
      // peso uruguayo (1975-1993)
      "UYP": [ "UYP", "UYP", 130],
      // peso uruguayo
      "UYU": [ "UYU", "$U", 2, "UY$"],
      // sum uzbeko
      "UZS": [ "UZS", "UZS", 0],
      // bolívar venezolano
      "VEB": [ "VEB", "VEB", 130],
      // bolívar fuerte venezolano
      "VEF": [ "VEF", "Bs.F.", 2],
      // dong vietnamita
      "VND": [ "VND", "₫", 24, "₫"],
      // vatu vanuatuense
      "VUV": [ "VUV", "VT", 0],
      // tala samoano
      "WST": [ "WST", "WS$", 2],
      // franco CFA BEAC
      "XAF": [ "XAF", "FCFA", 0],
      // plata
      "XAG": [ "XAG", "XAG", 2],
      // oro
      "XAU": [ "XAU", "XAU", 2],
      // unidad compuesta europea
      "XBA": [ "XBA", "XBA", 2],
      // unidad monetaria europea
      "XBB": [ "XBB", "XBB", 2],
      // unidad de cuenta europea (XBC)
      "XBC": [ "XBC", "XBC", 2],
      // unidad de cuenta europea (XBD)
      "XBD": [ "XBD", "XBD", 2],
      // dólar del Caribe Oriental
      "XCD": [ "XCD", "EC$", 2],
      // derechos especiales de giro
      "XDR": [ "XDR", "XDR", 2],
      // unidad de moneda europea
      "XEU": [ "XEU", "XEU", 2],
      // franco oro francés
      "XFO": [ "XFO", "XFO", 2],
      // franco UIC francés
      "XFU": [ "XFU", "XFU", 2],
      // franco CFA BCEAO
      "XOF": [ "XOF", "CFA", 0],
      // paladio
      "XPD": [ "XPD", "XPD", 2],
      // franco CFP
      "XPF": [ "XPF", "CFPF", 0],
      // platino
      "XPT": [ "XPT", "XPT", 2],
      // fondos RINET
      "XRE": [ "XRE", "XRE", 2],
      // código reservado para pruebas
      "XTS": [ "XTS", "XTS", 2],
      // Sin divisa
      "XXX": [ "XXX", "XXX", 2],
      // dinar yemení
      "YDD": [ "YDD", "YDD", 130],
      // rial yemení
      "YER": [ "YER", "YR", 0, "YER"],
      // dinar fuerte yugoslavo
      "YUD": [ "YUD", "YUD", 130],
      // super dinar yugoslavo
      "YUM": [ "YUM", "YUM", 130],
      // dinar convertible yugoslavo
      "YUN": [ "YUN", "YUN", 130],
      // rand sudafricano (financiero)
      "ZAL": [ "ZAL", "ZAL", 2],
      // rand sudafricano
      "ZAR": [ "ZAR", "R", 2, "ZAR"],
      // kwacha zambiano
      "ZMK": [ "ZMK", "ZK", 0],
      // nuevo zaire zaireño
      "ZRN": [ "ZRN", "NZ", 130],
      // zaire zaireño
      "ZRZ": [ "ZRZ", "ZRZ", 130],
      // dólar de Zimbabue
      "ZWD": [ "ZWD", "Z$", 128],
    };
  }-*/;
  
  @Override
  protected HashMap<String, String> loadNamesMapJava() {
    HashMap<String, String> result = super.loadNamesMapJava();
    result.put("ADP", "peseta andorrana");
    result.put("AED", "dírham de los Emiratos Árabes Unidos");
    result.put("AFA", "afgani (1927-2002)");
    result.put("AFN", "afgani");
    result.put("ALL", "lek albanés");
    result.put("AMD", "dram armenio");
    result.put("ANG", "florín de las Antillas Neerlandesas");
    result.put("AOA", "kwanza angoleño");
    result.put("AOK", "kwanza angoleño (1977-1990)");
    result.put("AON", "nuevo kwanza angoleño (1990-2000)");
    result.put("AOR", "kwanza reajustado angoleño (1995-1999)");
    result.put("ARA", "austral argentino");
    result.put("ARP", "peso argentino (1983-1985)");
    result.put("ARS", "peso argentino");
    result.put("ATS", "chelín austriaco");
    result.put("AUD", "dólar australiano");
    result.put("AWG", "florín de Aruba");
    result.put("AZM", "manat azerí (1993-2006)");
    result.put("AZN", "manat azerí");
    result.put("BAD", "dinar bosnio");
    result.put("BAM", "marco convertible de Bosnia-Herzegovina");
    result.put("BBD", "dólar de Barbados");
    result.put("BDT", "taka de Bangladesh");
    result.put("BEC", "franco belga (convertible)");
    result.put("BEF", "franco belga");
    result.put("BEL", "franco belga (financiero)");
    result.put("BGL", "lev fuerte búlgaro");
    result.put("BGN", "nuevo lev búlgaro");
    result.put("BHD", "dinar bahreiní");
    result.put("BIF", "franco de Burundi");
    result.put("BMD", "dólar de Bermudas");
    result.put("BND", "dólar de Brunéi");
    result.put("BOB", "boliviano");
    result.put("BOP", "peso boliviano");
    result.put("BOV", "MVDOL boliviano");
    result.put("BRB", "nuevo cruceiro brasileño (1967-1986)");
    result.put("BRC", "cruzado brasileño");
    result.put("BRE", "cruceiro brasileño (1990-1993)");
    result.put("BRL", "real brasileño");
    result.put("BRN", "nuevo cruzado brasileño");
    result.put("BRR", "cruceiro brasileño");
    result.put("BSD", "dólar de las Bahamas");
    result.put("BTN", "ngultrum butanés");
    result.put("BUK", "kyat birmano");
    result.put("BWP", "pula botsuano");
    result.put("BYB", "nuevo rublo bielorruso (1994-1999)");
    result.put("BYR", "rublo bielorruso");
    result.put("BZD", "dólar de Belice");
    result.put("CAD", "dólar canadiense");
    result.put("CDF", "franco congoleño");
    result.put("CHE", "euro WIR");
    result.put("CHF", "franco suizo");
    result.put("CHW", "franco WIR");
    result.put("CLF", "unidad de fomento chilena");
    result.put("CLP", "peso chileno");
    result.put("CNY", "yuan renminbi chino");
    result.put("COP", "peso colombiano");
    result.put("COU", "unidad de valor real colombiana");
    result.put("CRC", "colón costarricense");
    result.put("CSD", "antiguo dinar serbio");
    result.put("CSK", "corona fuerte checoslovaca");
    result.put("CUP", "peso cubano");
    result.put("CVE", "escudo de Cabo Verde");
    result.put("CYP", "libra chipriota");
    result.put("CZK", "corona checa");
    result.put("DDM", "ostmark de Alemania del Este");
    result.put("DEM", "marco alemán");
    result.put("DJF", "franco de Yibuti");
    result.put("DKK", "corona danesa");
    result.put("DOP", "peso dominicano");
    result.put("DZD", "dinar argelino");
    result.put("ECS", "sucre ecuatoriano");
    result.put("ECV", "unidad de valor constante (UVC) ecuatoriana");
    result.put("EEK", "corona estonia");
    result.put("EGP", "libra egipcia");
    result.put("ERN", "nakfa eritreo");
    result.put("ESA", "peseta española (cuenta A)");
    result.put("ESB", "peseta española (cuenta convertible)");
    result.put("ESP", "peseta española");
    result.put("ETB", "birr etíope");
    result.put("EUR", "euro");
    result.put("FIM", "marco finlandés");
    result.put("FJD", "dólar de las Islas Fiyi");
    result.put("FKP", "libra de las Islas Malvinas");
    result.put("FRF", "franco francés");
    result.put("GBP", "libra esterlina británica");
    result.put("GEK", "kupon larit georgiano");
    result.put("GEL", "lari georgiano");
    result.put("GHC", "cedi ghanés");
    result.put("GIP", "libra de Gibraltar");
    result.put("GMD", "dalasi gambiano");
    result.put("GNF", "franco guineano");
    result.put("GNS", "syli guineano");
    result.put("GQE", "ekuele de Guinea Ecuatorial");
    result.put("GRD", "dracma griego");
    result.put("GTQ", "quetzal guatemalteco");
    result.put("GWE", "escudo de Guinea Portuguesa");
    result.put("GWP", "peso de Guinea-Bissáu");
    result.put("GYD", "dólar guyanés");
    result.put("HKD", "dólar de Hong Kong");
    result.put("HNL", "lempira hondureño");
    result.put("HRD", "dinar croata");
    result.put("HRK", "kuna croata");
    result.put("HTG", "gourde haitiano");
    result.put("HUF", "florín húngaro");
    result.put("IDR", "rupia indonesia");
    result.put("IEP", "libra irlandesa");
    result.put("ILP", "libra israelí");
    result.put("ILS", "nuevo sheqel israelí");
    result.put("INR", "rupia india");
    result.put("IQD", "dinar iraquí");
    result.put("IRR", "rial iraní");
    result.put("ISK", "corona islandesa");
    result.put("ITL", "lira italiana");
    result.put("JMD", "dólar de Jamaica");
    result.put("JOD", "dinar jordano");
    result.put("JPY", "yen japonés");
    result.put("KES", "chelín keniata");
    result.put("KGS", "som kirguís");
    result.put("KHR", "riel camboyano");
    result.put("KMF", "franco comorense");
    result.put("KPW", "won norcoreano");
    result.put("KRW", "won surcoreano");
    result.put("KWD", "dinar kuwaití");
    result.put("KYD", "dólar de las Islas Caimán");
    result.put("KZT", "tenge kazako");
    result.put("LAK", "kip laosiano");
    result.put("LBP", "libra libanesa");
    result.put("LKR", "rupia de Sri Lanka");
    result.put("LRD", "dólar liberiano");
    result.put("LSL", "loti lesothense");
    result.put("LTL", "litas lituano");
    result.put("LTT", "talonas lituano");
    result.put("LUC", "franco convertible luxemburgués");
    result.put("LUF", "franco luxemburgués");
    result.put("LUL", "franco financiero luxemburgués");
    result.put("LVL", "lats letón");
    result.put("LVR", "rublo letón");
    result.put("LYD", "dinar libio");
    result.put("MAD", "dirham marroquí");
    result.put("MAF", "franco marroquí");
    result.put("MDL", "leu moldavo");
    result.put("MGA", "ariary malgache");
    result.put("MGF", "franco malgache");
    result.put("MKD", "dinar macedonio");
    result.put("MLF", "franco malí");
    result.put("MMK", "kyat de Myanmar");
    result.put("MNT", "tugrik mongol");
    result.put("MOP", "pataca de Macao");
    result.put("MRO", "ouguiya mauritano");
    result.put("MTL", "lira maltesa");
    result.put("MTP", "libra maltesa");
    result.put("MUR", "rupia mauriciana");
    result.put("MVR", "rufiyaa de Maldivas");
    result.put("MWK", "kwacha de Malawi");
    result.put("MXN", "peso mexicano");
    result.put("MXP", "peso de plata mexicano (1861-1992)");
    result.put("MXV", "unidad de inversión (UDI) mexicana");
    result.put("MYR", "ringgit malasio");
    result.put("MZE", "escudo mozambiqueño");
    result.put("MZM", "antiguo metical mozambiqueño");
    result.put("MZN", "metical mozambiqueño");
    result.put("NAD", "dólar de Namibia");
    result.put("NGN", "naira nigeriano");
    result.put("NIC", "córdoba nicaragüense");
    result.put("NIO", "córdoba oro nicaragüense");
    result.put("NLG", "florín neerlandés");
    result.put("NOK", "corona noruega");
    result.put("NPR", "rupia nepalesa");
    result.put("NZD", "dólar neozelandés");
    result.put("OMR", "rial omaní");
    result.put("PAB", "balboa panameño");
    result.put("PEI", "inti peruano");
    result.put("PEN", "nuevo sol peruano");
    result.put("PES", "sol peruano");
    result.put("PGK", "kina de Papúa Nueva Guinea");
    result.put("PHP", "peso filipino");
    result.put("PKR", "rupia pakistaní");
    result.put("PLN", "zloty polaco");
    result.put("PLZ", "zloty polaco (1950-1995)");
    result.put("PTE", "escudo portugués");
    result.put("PYG", "guaraní paraguayo");
    result.put("QAR", "riyal de Qatar");
    result.put("RHD", "dólar rodesiano");
    result.put("ROL", "antiguo leu rumano");
    result.put("RON", "leu rumano");
    result.put("RSD", "dinar serbio");
    result.put("RUB", "rublo ruso");
    result.put("RUR", "rublo ruso (1991-1998)");
    result.put("RWF", "franco ruandés");
    result.put("SAR", "riyal saudí");
    result.put("SBD", "dólar de las Islas Salomón");
    result.put("SCR", "rupia de Seychelles");
    result.put("SDD", "dinar sudanés");
    result.put("SDG", "libra sudanesa");
    result.put("SDP", "libra sudanesa antigua");
    result.put("SEK", "corona sueca");
    result.put("SGD", "dólar singapurense");
    result.put("SHP", "libra de Santa Elena");
    result.put("SIT", "tólar esloveno");
    result.put("SKK", "corona eslovaca");
    result.put("SLL", "leone de Sierra Leona");
    result.put("SOS", "chelín somalí");
    result.put("SRD", "dólar surinamés");
    result.put("SRG", "florín surinamés");
    result.put("STD", "dobra de Santo Tomé y Príncipe");
    result.put("SUR", "rublo soviético");
    result.put("SVC", "colón salvadoreño");
    result.put("SYP", "libra siria");
    result.put("SZL", "lilangeni suazi");
    result.put("THB", "baht tailandés");
    result.put("TJR", "rublo tayiko");
    result.put("TJS", "somoni tayiko");
    result.put("TMM", "manat turcomano");
    result.put("TND", "dinar tunecino");
    result.put("TOP", "paʻanga tongano");
    result.put("TPE", "escudo timorense");
    result.put("TRL", "lira turca antigua");
    result.put("TRY", "nueva lira turca");
    result.put("TTD", "dólar de Trinidad y Tobago");
    result.put("TWD", "nuevo dólar taiwanés");
    result.put("TZS", "chelín tanzano");
    result.put("UAH", "grivna ucraniana");
    result.put("UAK", "karbovanet ucraniano");
    result.put("UGS", "chelín ugandés (1966-1987)");
    result.put("UGX", "chelín ugandés");
    result.put("USD", "dólar estadounidense");
    result.put("USN", "dólar estadounidense (día siguiente)");
    result.put("USS", "dólar estadounidense (mismo día)");
    result.put("UYI", "peso uruguayo en unidades indexadas");
    result.put("UYP", "peso uruguayo (1975-1993)");
    result.put("UYU", "peso uruguayo");
    result.put("UZS", "sum uzbeko");
    result.put("VEB", "bolívar venezolano");
    result.put("VEF", "bolívar fuerte venezolano");
    result.put("VND", "dong vietnamita");
    result.put("VUV", "vatu vanuatuense");
    result.put("WST", "tala samoano");
    result.put("XAF", "franco CFA BEAC");
    result.put("XAG", "plata");
    result.put("XAU", "oro");
    result.put("XBA", "unidad compuesta europea");
    result.put("XBB", "unidad monetaria europea");
    result.put("XBC", "unidad de cuenta europea (XBC)");
    result.put("XBD", "unidad de cuenta europea (XBD)");
    result.put("XCD", "dólar del Caribe Oriental");
    result.put("XDR", "derechos especiales de giro");
    result.put("XEU", "unidad de moneda europea");
    result.put("XFO", "franco oro francés");
    result.put("XFU", "franco UIC francés");
    result.put("XOF", "franco CFA BCEAO");
    result.put("XPD", "paladio");
    result.put("XPF", "franco CFP");
    result.put("XPT", "platino");
    result.put("XRE", "fondos RINET");
    result.put("XTS", "código reservado para pruebas");
    result.put("XXX", "Sin divisa");
    result.put("YDD", "dinar yemení");
    result.put("YER", "rial yemení");
    result.put("YUD", "dinar fuerte yugoslavo");
    result.put("YUM", "super dinar yugoslavo");
    result.put("YUN", "dinar convertible yugoslavo");
    result.put("ZAL", "rand sudafricano (financiero)");
    result.put("ZAR", "rand sudafricano");
    result.put("ZMK", "kwacha zambiano");
    result.put("ZRN", "nuevo zaire zaireño");
    result.put("ZRZ", "zaire zaireño");
    result.put("ZWD", "dólar de Zimbabue");
    return result;
  }
  
  @Override
  protected JavaScriptObject loadNamesMapNative() {
    return overrideMap(super.loadNamesMapNative(), loadMyNamesMapOverridesNative());
  }
  
  private native JavaScriptObject loadMyNamesMapOverridesNative() /*-{
    return {
      "ADP": "peseta andorrana",
      "AED": "dírham de los Emiratos Árabes Unidos",
      "AFA": "afgani (1927-2002)",
      "AFN": "afgani",
      "ALL": "lek albanés",
      "AMD": "dram armenio",
      "ANG": "florín de las Antillas Neerlandesas",
      "AOA": "kwanza angoleño",
      "AOK": "kwanza angoleño (1977-1990)",
      "AON": "nuevo kwanza angoleño (1990-2000)",
      "AOR": "kwanza reajustado angoleño (1995-1999)",
      "ARA": "austral argentino",
      "ARP": "peso argentino (1983-1985)",
      "ARS": "peso argentino",
      "ATS": "chelín austriaco",
      "AUD": "dólar australiano",
      "AWG": "florín de Aruba",
      "AZM": "manat azerí (1993-2006)",
      "AZN": "manat azerí",
      "BAD": "dinar bosnio",
      "BAM": "marco convertible de Bosnia-Herzegovina",
      "BBD": "dólar de Barbados",
      "BDT": "taka de Bangladesh",
      "BEC": "franco belga (convertible)",
      "BEF": "franco belga",
      "BEL": "franco belga (financiero)",
      "BGL": "lev fuerte búlgaro",
      "BGN": "nuevo lev búlgaro",
      "BHD": "dinar bahreiní",
      "BIF": "franco de Burundi",
      "BMD": "dólar de Bermudas",
      "BND": "dólar de Brunéi",
      "BOB": "boliviano",
      "BOP": "peso boliviano",
      "BOV": "MVDOL boliviano",
      "BRB": "nuevo cruceiro brasileño (1967-1986)",
      "BRC": "cruzado brasileño",
      "BRE": "cruceiro brasileño (1990-1993)",
      "BRL": "real brasileño",
      "BRN": "nuevo cruzado brasileño",
      "BRR": "cruceiro brasileño",
      "BSD": "dólar de las Bahamas",
      "BTN": "ngultrum butanés",
      "BUK": "kyat birmano",
      "BWP": "pula botsuano",
      "BYB": "nuevo rublo bielorruso (1994-1999)",
      "BYR": "rublo bielorruso",
      "BZD": "dólar de Belice",
      "CAD": "dólar canadiense",
      "CDF": "franco congoleño",
      "CHE": "euro WIR",
      "CHF": "franco suizo",
      "CHW": "franco WIR",
      "CLF": "unidad de fomento chilena",
      "CLP": "peso chileno",
      "CNY": "yuan renminbi chino",
      "COP": "peso colombiano",
      "COU": "unidad de valor real colombiana",
      "CRC": "colón costarricense",
      "CSD": "antiguo dinar serbio",
      "CSK": "corona fuerte checoslovaca",
      "CUP": "peso cubano",
      "CVE": "escudo de Cabo Verde",
      "CYP": "libra chipriota",
      "CZK": "corona checa",
      "DDM": "ostmark de Alemania del Este",
      "DEM": "marco alemán",
      "DJF": "franco de Yibuti",
      "DKK": "corona danesa",
      "DOP": "peso dominicano",
      "DZD": "dinar argelino",
      "ECS": "sucre ecuatoriano",
      "ECV": "unidad de valor constante (UVC) ecuatoriana",
      "EEK": "corona estonia",
      "EGP": "libra egipcia",
      "ERN": "nakfa eritreo",
      "ESA": "peseta española (cuenta A)",
      "ESB": "peseta española (cuenta convertible)",
      "ESP": "peseta española",
      "ETB": "birr etíope",
      "EUR": "euro",
      "FIM": "marco finlandés",
      "FJD": "dólar de las Islas Fiyi",
      "FKP": "libra de las Islas Malvinas",
      "FRF": "franco francés",
      "GBP": "libra esterlina británica",
      "GEK": "kupon larit georgiano",
      "GEL": "lari georgiano",
      "GHC": "cedi ghanés",
      "GIP": "libra de Gibraltar",
      "GMD": "dalasi gambiano",
      "GNF": "franco guineano",
      "GNS": "syli guineano",
      "GQE": "ekuele de Guinea Ecuatorial",
      "GRD": "dracma griego",
      "GTQ": "quetzal guatemalteco",
      "GWE": "escudo de Guinea Portuguesa",
      "GWP": "peso de Guinea-Bissáu",
      "GYD": "dólar guyanés",
      "HKD": "dólar de Hong Kong",
      "HNL": "lempira hondureño",
      "HRD": "dinar croata",
      "HRK": "kuna croata",
      "HTG": "gourde haitiano",
      "HUF": "florín húngaro",
      "IDR": "rupia indonesia",
      "IEP": "libra irlandesa",
      "ILP": "libra israelí",
      "ILS": "nuevo sheqel israelí",
      "INR": "rupia india",
      "IQD": "dinar iraquí",
      "IRR": "rial iraní",
      "ISK": "corona islandesa",
      "ITL": "lira italiana",
      "JMD": "dólar de Jamaica",
      "JOD": "dinar jordano",
      "JPY": "yen japonés",
      "KES": "chelín keniata",
      "KGS": "som kirguís",
      "KHR": "riel camboyano",
      "KMF": "franco comorense",
      "KPW": "won norcoreano",
      "KRW": "won surcoreano",
      "KWD": "dinar kuwaití",
      "KYD": "dólar de las Islas Caimán",
      "KZT": "tenge kazako",
      "LAK": "kip laosiano",
      "LBP": "libra libanesa",
      "LKR": "rupia de Sri Lanka",
      "LRD": "dólar liberiano",
      "LSL": "loti lesothense",
      "LTL": "litas lituano",
      "LTT": "talonas lituano",
      "LUC": "franco convertible luxemburgués",
      "LUF": "franco luxemburgués",
      "LUL": "franco financiero luxemburgués",
      "LVL": "lats letón",
      "LVR": "rublo letón",
      "LYD": "dinar libio",
      "MAD": "dirham marroquí",
      "MAF": "franco marroquí",
      "MDL": "leu moldavo",
      "MGA": "ariary malgache",
      "MGF": "franco malgache",
      "MKD": "dinar macedonio",
      "MLF": "franco malí",
      "MMK": "kyat de Myanmar",
      "MNT": "tugrik mongol",
      "MOP": "pataca de Macao",
      "MRO": "ouguiya mauritano",
      "MTL": "lira maltesa",
      "MTP": "libra maltesa",
      "MUR": "rupia mauriciana",
      "MVR": "rufiyaa de Maldivas",
      "MWK": "kwacha de Malawi",
      "MXN": "peso mexicano",
      "MXP": "peso de plata mexicano (1861-1992)",
      "MXV": "unidad de inversión (UDI) mexicana",
      "MYR": "ringgit malasio",
      "MZE": "escudo mozambiqueño",
      "MZM": "antiguo metical mozambiqueño",
      "MZN": "metical mozambiqueño",
      "NAD": "dólar de Namibia",
      "NGN": "naira nigeriano",
      "NIC": "córdoba nicaragüense",
      "NIO": "córdoba oro nicaragüense",
      "NLG": "florín neerlandés",
      "NOK": "corona noruega",
      "NPR": "rupia nepalesa",
      "NZD": "dólar neozelandés",
      "OMR": "rial omaní",
      "PAB": "balboa panameño",
      "PEI": "inti peruano",
      "PEN": "nuevo sol peruano",
      "PES": "sol peruano",
      "PGK": "kina de Papúa Nueva Guinea",
      "PHP": "peso filipino",
      "PKR": "rupia pakistaní",
      "PLN": "zloty polaco",
      "PLZ": "zloty polaco (1950-1995)",
      "PTE": "escudo portugués",
      "PYG": "guaraní paraguayo",
      "QAR": "riyal de Qatar",
      "RHD": "dólar rodesiano",
      "ROL": "antiguo leu rumano",
      "RON": "leu rumano",
      "RSD": "dinar serbio",
      "RUB": "rublo ruso",
      "RUR": "rublo ruso (1991-1998)",
      "RWF": "franco ruandés",
      "SAR": "riyal saudí",
      "SBD": "dólar de las Islas Salomón",
      "SCR": "rupia de Seychelles",
      "SDD": "dinar sudanés",
      "SDG": "libra sudanesa",
      "SDP": "libra sudanesa antigua",
      "SEK": "corona sueca",
      "SGD": "dólar singapurense",
      "SHP": "libra de Santa Elena",
      "SIT": "tólar esloveno",
      "SKK": "corona eslovaca",
      "SLL": "leone de Sierra Leona",
      "SOS": "chelín somalí",
      "SRD": "dólar surinamés",
      "SRG": "florín surinamés",
      "STD": "dobra de Santo Tomé y Príncipe",
      "SUR": "rublo soviético",
      "SVC": "colón salvadoreño",
      "SYP": "libra siria",
      "SZL": "lilangeni suazi",
      "THB": "baht tailandés",
      "TJR": "rublo tayiko",
      "TJS": "somoni tayiko",
      "TMM": "manat turcomano",
      "TND": "dinar tunecino",
      "TOP": "paʻanga tongano",
      "TPE": "escudo timorense",
      "TRL": "lira turca antigua",
      "TRY": "nueva lira turca",
      "TTD": "dólar de Trinidad y Tobago",
      "TWD": "nuevo dólar taiwanés",
      "TZS": "chelín tanzano",
      "UAH": "grivna ucraniana",
      "UAK": "karbovanet ucraniano",
      "UGS": "chelín ugandés (1966-1987)",
      "UGX": "chelín ugandés",
      "USD": "dólar estadounidense",
      "USN": "dólar estadounidense (día siguiente)",
      "USS": "dólar estadounidense (mismo día)",
      "UYI": "peso uruguayo en unidades indexadas",
      "UYP": "peso uruguayo (1975-1993)",
      "UYU": "peso uruguayo",
      "UZS": "sum uzbeko",
      "VEB": "bolívar venezolano",
      "VEF": "bolívar fuerte venezolano",
      "VND": "dong vietnamita",
      "VUV": "vatu vanuatuense",
      "WST": "tala samoano",
      "XAF": "franco CFA BEAC",
      "XAG": "plata",
      "XAU": "oro",
      "XBA": "unidad compuesta europea",
      "XBB": "unidad monetaria europea",
      "XBC": "unidad de cuenta europea (XBC)",
      "XBD": "unidad de cuenta europea (XBD)",
      "XCD": "dólar del Caribe Oriental",
      "XDR": "derechos especiales de giro",
      "XEU": "unidad de moneda europea",
      "XFO": "franco oro francés",
      "XFU": "franco UIC francés",
      "XOF": "franco CFA BCEAO",
      "XPD": "paladio",
      "XPF": "franco CFP",
      "XPT": "platino",
      "XRE": "fondos RINET",
      "XTS": "código reservado para pruebas",
      "XXX": "Sin divisa",
      "YDD": "dinar yemení",
      "YER": "rial yemení",
      "YUD": "dinar fuerte yugoslavo",
      "YUM": "super dinar yugoslavo",
      "YUN": "dinar convertible yugoslavo",
      "ZAL": "rand sudafricano (financiero)",
      "ZAR": "rand sudafricano",
      "ZMK": "kwacha zambiano",
      "ZRN": "nuevo zaire zaireño",
      "ZRZ": "zaire zaireño",
      "ZWD": "dólar de Zimbabue",
    };
  }-*/;
}
