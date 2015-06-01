package webDashboards.model;

import com.redprairie.moca.MocaException;
import com.redprairie.moca.MocaResults;

public class Consultas extends MocaConnection {

    public MocaResults getReceivingDashboardsData (String andenes) throws MocaException {
        MocaResults res;
        String sCmdBuffer;
        
        sCmdBuffer = "[select locmst.stoloc "
                + "      from locmst "
                + "     where locmst.stoloc in ('R-ANDEN01', 'R-ANDEN02', 'R-ANDEN03', 'R-ANDEN04') "
                + "       and locmst.wh_id = '7']"
                + "   |" 
                + "   [select trlr.yard_loc, "
                + "           rcvlin.invnum, "
                + "           (select adrmst.first_name "
                + "              from adrmst "
                + "             where supmst.adr_id = adrmst.adr_id) first_name, "
                + "           trlr.trlr_stat, "
                + "           sum(rcvlin.expqty) expqty, "
                + "           sum(rcvlin.rcvqty) rcvqty, "
                + "           sum(rcvlin.expqty) - sum(rcvlin.rcvqty) to_rcvqty, "
                + "           (sum(rcvlin.rcvqty) * 100) / sum(rcvlin.expqty) percentage_rcvqty, "
                + "           ((sum(rcvlin.expqty) - sum(rcvlin.rcvqty)) * 100) / sum(rcvlin.expqty) percentage_to_rcvqty "
                + "      from rcvinv left outer "
                + "      join rcvlin "
                + "        on rcvinv.trknum = rcvlin.trknum "
                + "       and rcvinv.supnum = rcvlin.supnum "
                + "       and rcvinv.invnum = rcvlin.invnum "
                + "       and rcvinv.wh_id = rcvlin.wh_id "
                + "       and rcvinv.client_id = rcvlin.client_id "
                + "      left outer "
                + "      join rcvtrk "
                + "        on rcvlin.trknum = rcvtrk.trknum "
                + "       and rcvlin.wh_id = rcvtrk.wh_id "
                + "       and rcvinv.trknum = rcvtrk.trknum "
                + "       and rcvinv.wh_id = rcvtrk.wh_id "
                + "      left outer join trlr "
                + "        on rcvtrk.trlr_id = trlr.trlr_id "
                + "      left outer join supmst "
                + "        on rcvinv.client_id = supmst.client_id "
                + "       and rcvinv.supnum = supmst.supnum "
                + "     where trlr.yard_loc = @stoloc "
                + "     group by trlr.yard_loc, "
                + "           rcvlin.invnum, "
                + "           trlr.trlr_stat,"
                + "           supmst.adr_id "
                + "     order by 1] catch(@?)"
                + "   |"
                + "   if (@? = 0) "
                + "   { "
                + "   publish data "
                + "     where yard_loc = @stoloc "
                + "       and invnum = @invnum "
                + "       and first_name = @first_name "
                + "       and trlr_stat = @trlr_stat "
                + "       and expqty = @expqty "
                + "       and rcvqty = @rcvqty "
                + "       and to_rcvqty = @to_rcvqty "
                + "       and percentage_rcvqty = @percentage_rcvqty "
                + "       and percentage_to_rcvqty = @percentage_to_rcvqty "
                + "   } "
                + "   else "
                + "   { "
                + "   publish data "
                + "     where yard_loc = @stoloc "
                + "       and invnum = '' "
                + "       and first_name = '' "
                + "       and trlr_stat = '' "
                + "       and expqty = '0' "
                + "       and rcvqty = '0' "
                + "       and to_rcvqty = '0' "
                + "       and percentage_rcvqty = '0' "
                + "       and percentage_to_rcvqty = '0' "
                + "   }";
        
        res = conn.executeCommand(sCmdBuffer);
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
