package ShippingCostHomework;

public class WorkloadRatio {
    public double Workload (int ratioWorkload) {
        double ratio;
        switch (ratioWorkload) {
            case 4:
                ratio = 1.6;
                break;
            case 3:
                ratio = 1.4;
                break;
            case 2:
                ratio = 1.2;
                break;
            case 1:
                ratio = 1;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + ratioWorkload);
        }
        return ratio;
    }
}
